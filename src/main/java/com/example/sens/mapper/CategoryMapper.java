package com.example.sens.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.sens.entity.Category;
import com.example.sens.entity.Report;
import com.example.sens.entity.User;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/15 10:25 下午
 */

public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> findAll(Pagination pagination);
}
