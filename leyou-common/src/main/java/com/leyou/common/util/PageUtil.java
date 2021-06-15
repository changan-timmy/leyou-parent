package com.leyou.common.util;


import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.Pageable;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


public class PageUtil<T> {

    /**
     * 获取分页数据
     * @param page 查询的页面 从 0 开始
     * @param size 每页显示条数 默认 20条
     * @return
     */
    public static Pageable getPageable(Integer page, Integer size){
        if (null == page) {
            page = 0;
        }
        if (null == size || size > 10000) {
            size = 20;
        }
        return new Pageable(page, size);
    }



    /**
     * 获取分页数据，带排序条件
     * @param page 分页页码 从 0 开始
     * @param rows  每页显示条数 默认 20 条
     * @param sortBy 排序字段
     * @param desc 是否降序
     * @return
     */
    public static Pageable getPageable(Integer page, Integer rows, String sortBy, Boolean desc){

        if (null == page) {
            page = 0;
        }
        if (null == rows || rows > 10000) {
            rows = 20;
        }
        return new Pageable(page,rows,sortBy,desc);
    }

    /**
     * 返回空列表
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> getEmptyPage() {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setList(new ArrayList<>());
        pageResult.setTotal(0L);
        pageResult.setTotalPage(0L);
        return pageResult;
    }

    /**
     * 返回分页列表
     * @param list
     * @param count
     * @param pageable
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> getPageResult(List<T> list, Integer count, Pageable pageable) {
        Long cnt = Long.valueOf(count);
        PageResult<T> pageResult = new PageResult<T>();
        pageResult.setList(list);
        pageResult.setTotal(cnt);
        pageResult.setTotalPage(cnt/pageable.getRows()+1);
        return pageResult;
    }

    public static void setSort(Example example, Pageable pageable) {
        example.setOrderByClause(pageable.getSortBy() + " " + (null == pageable.getDesc() || pageable.getDesc() ? "desc" : "asc"));
    }

    public static<T> PageResult<T> getPageInfoResult(long total,long totalPage, List<T> list) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setList(list);
        pageResult.setTotalPage(totalPage);
        return pageResult;
    }
}
