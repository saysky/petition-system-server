package com.example.sens.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Category;
import com.example.sens.mapper.CategoryMapper;
import com.example.sens.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *     分类业务逻辑实现类
 * </pre>
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public void saveByCategory(Category category) {
        if (category != null && category.getId() != null) {
            categoryMapper.updateById(category);
        } else {
            categoryMapper.insert(category);
        }
    }

   
    @Override
    public Category findByCategoryId(Long categoryId) {
        return categoryMapper.selectById(categoryId);
    }


    @Override
    public void removeCategory(Long categoryId) {
        categoryMapper.deleteById(categoryId);
    }

    @Override
    public Page<Category> findAll(Page<Category> page) {
        return page.setRecords(categoryMapper.findAll(page));
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectList(null);
    }
}
