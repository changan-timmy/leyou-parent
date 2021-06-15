package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.Pageable;
import com.leyou.item.bo.BrandBo;
import com.leyou.item.dao.BrandDao;
import com.leyou.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public PageResult<Brand> findPageByBo(BrandBo bo, Pageable pageable) {
        PageResult<Brand> pageResult = brandDao.findPageByBo(bo,pageable);
        return pageResult;
    }
}
