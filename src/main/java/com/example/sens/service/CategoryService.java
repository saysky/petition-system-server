package com.example.sens.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Category;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/15 10:24 下午
 */
public interface CategoryService {


    /**
     * 新增/修改分类
     *
     * @param category category
     * @return Role
     */
    void saveByCategory(Category category);

    /**
     * 根据分类Id获得分类
     *
     * @param categoryId 分类名
     * @return 分类
     */
    Category findByCategoryId(Long categoryId);

    /**
     * 删除分类
     *
     * @param categoryId 分类Id
     */
    void removeCategory(Long categoryId);


    /**
     * 分页获取分类
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Category> findAll(Page<Category> page);

    List<Category> findAll();
}
