package com.example.springfinaltest.service;

import com.example.springfinaltest.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    List<Category> showAll();

    void delete(Long id);

    Category findById(Long id);

}
