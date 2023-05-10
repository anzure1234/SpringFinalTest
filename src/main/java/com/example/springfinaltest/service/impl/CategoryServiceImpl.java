package com.example.springfinaltest.service.impl;

import com.example.springfinaltest.entity.Category;
import com.example.springfinaltest.repository.CategoryRepository;
import com.example.springfinaltest.service.CategoryService;
import com.example.springfinaltest.service.CertService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CertService certService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CertService certService) {
        this.categoryRepository = categoryRepository;
        this.certService = certService;
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

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Map<String, Object>> getCategoryStats() {
        List<Category> categories = showAll();
        List<Map<String, Object>> categoryStats = new ArrayList<>();

        for (Category category : categories) {
            Map<String, Object> stats = new HashMap<>();
            stats.put("name", category.getName());
            stats.put("total", certService.countByCategory(category.getId()));
            categoryStats.add(stats);
        }

        return categoryStats;
    }


}
