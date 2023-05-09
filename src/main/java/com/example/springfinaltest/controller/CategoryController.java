package com.example.springfinaltest.controller;

import com.example.springfinaltest.dto.CategoryListDto;
import com.example.springfinaltest.dto.CertListDto;
import com.example.springfinaltest.entity.Category;
import com.example.springfinaltest.entity.Cert;
import com.example.springfinaltest.service.CategoryService;
import com.example.springfinaltest.service.CertService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final CertService certService;


    public CategoryController(CategoryService categoryService, CertService certService) {
        this.categoryService = categoryService;
        this.certService = certService;
    }

    @GetMapping("/category")
    public String showCategory(Model model) {
        model.addAttribute("categoryList", new CategoryListDto());
        return "/index";
    }

    @PostMapping("/category/add")
    public String addCategory(@Valid CategoryListDto categoryListDto,@Valid CertListDto certListDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        Category category = new Category();
        Cert cert = new Cert();
        BeanUtils.copyProperties(categoryListDto, category);
        BeanUtils.copyProperties(certListDto, cert);

        categoryService.save(category);

        certService.save(cert);
        redirectAttributes.addFlashAttribute("successMessage", "category.add.success");
        return "redirect:/category";
    }


    @PostMapping("/category/edit/{id}")



}
