package com.leyou.item.service;

import com.leyou.item.bo.BrandBo;
import com.leyou.item.dao.BrandDao;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandDao brandDao;

    @Override
    public Page<Brand> findPageByBo(BrandBo bo, Pageable pageable) {
        List<Brand> brands = brandMapper.selectAll();
        Page<Brand> all1 = new PageImpl(brands);
        Page<Brand> all2 = brandDao.findAll(pageable);
        return all2;
    }
}
