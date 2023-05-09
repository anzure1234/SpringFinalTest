package com.example.springfinaltest.service.impl;

import com.example.springfinaltest.entity.Category;
import com.example.springfinaltest.repository.CategoryRepository;
import com.example.springfinaltest.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> showAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}