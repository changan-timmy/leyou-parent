package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.Pageable;
import com.leyou.item.bo.BrandBo;
import com.leyou.item.pojo.Brand;

public interface BrandService {
    PageResult<Brand> findPageByBo(BrandBo bo, Pageable pageable);
}
