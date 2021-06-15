package com.leyou.item.service;

import com.leyou.item.bo.BrandBo;
import com.leyou.item.pojo.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    Page<Brand> findPageByBo(BrandBo bo, Pageable pageable);
}
