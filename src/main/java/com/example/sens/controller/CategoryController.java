package com.example.sens.controller;

import com.example.sens.entity.Category;
import com.example.sens.service.CategoryService;
import com.example.sens.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/16 9:47 上午
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Response<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return Response.yes(categories);
    }
}
