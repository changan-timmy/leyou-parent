package com.leyou.common.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtil {

    /**
     * 获取分页数据
     * @param page 查询的页面 从 0 开始
     * @param size 每页显示条数 默认 20条
     * @return
     */
    public static Pageable getPageable(Integer page, Integer size){
        return getPageable(page, size,Sort.unsorted());
    }

    /**
     *
     * @param page
     * @param size
     * @param sortBy
     * @param direction
     * @return
     */
    public static Pageable getPageable(Integer page, Integer size,String sortBy,Sort.Direction direction){
        if (StringUtils.isNotEmpty(sortBy)) {
            return getPageable(page,size,Sort.by(direction,sortBy));
        }
        return getPageable(page, size,Sort.unsorted());
    }

    /**
     * 获取分页数据，带排序条件
     * @param page 分页页码 从 0 开始
     * @param size  每页显示条数 默认 20 条
     * @param sort 排序
     * @return
     */
    public static Pageable getPageable(Integer page, Integer size, Sort sort){
        if (null == page) {
            page = 0;
        }
        if (null == size || size > 10000) {
            size = 20;
        }
        return PageRequest.of(page, size,sort);
    }
}
