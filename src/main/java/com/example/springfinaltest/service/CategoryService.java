package com.example.springfinaltest.service;

import com.example.springfinaltest.entity.Category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryService {

    void save(Category category);

    List<Category> showAll();

    void delete(Long id);

    Optional<Category> findById(Long id);

    public List<Map<String, Object>> getCategoryStats();

}
