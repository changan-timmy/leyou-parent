package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.Pageable;
import com.leyou.common.util.PageUtil;
import com.leyou.item.bo.BrandBo;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand/page")
    @ResponseBody
    public ResponseEntity<PageResult<Brand>> findPageByBo(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", required = false) Boolean desc
    ) {
        Pageable pageable = PageUtil.getPageable(page, rows, sortBy, desc);
        BrandBo bo = new BrandBo();
        bo.setKey(key);
        PageResult<Brand> pageResult = brandService.findPageByBo(bo, pageable);
        return ResponseEntity.ok(pageResult);
    }


}
