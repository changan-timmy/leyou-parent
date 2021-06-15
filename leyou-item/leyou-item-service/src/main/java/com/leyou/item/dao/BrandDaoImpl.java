package com.leyou.item.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.Pageable;
import com.leyou.common.util.PageUtil;
import com.leyou.item.bo.BrandBo;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BrandDaoImpl implements BrandDao{

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> findPageByBo(BrandBo bo, Pageable pageable) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageable.getPage(),pageable.getRows());

        if (StringUtils.isNotEmpty(bo.getKey())) {
            criteria.andLike("name","%"+bo.getKey()+"%").orEqualTo("letter",bo.getKey());
        }
        if(StringUtils.isNotBlank(pageable.getSortBy())){
            PageUtil.setSort(example,pageable);
        }

        List<Brand> brands = brandMapper.selectByExample(example);
        int count = brands.size();
        brands = brands.stream().skip((pageable.getPage() - 1) * pageable.getRows()).limit(pageable.getRows()).collect(Collectors.toList());

        return PageUtil.getPageInfoResult(count, count / pageable.getRows() + 1,brands);
    }
}
