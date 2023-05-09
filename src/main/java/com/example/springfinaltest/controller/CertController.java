package com.example.springfinaltest.controller;


import com.example.springfinaltest.constant.AppConstant;
import com.example.springfinaltest.dto.CertListDto;
import com.example.springfinaltest.entity.Category;
import com.example.springfinaltest.entity.Cert;
import com.example.springfinaltest.service.CategoryService;
import com.example.springfinaltest.service.CertService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CertController {
    private final CertService certService;
    private final CategoryService categoryService;

    public CertController(CertService certService, CategoryService categoryService) {
        this.certService = certService;
        this.categoryService = categoryService;
    }

    @GetMapping("/cert")
    public String showCert(Model model,
                           @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_STR) Integer page,
                           @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE_STR) Integer size) {


        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Cert> certPage = certService.findAllPaging(null,pageRequest);
        model.addAttribute("certPage", certPage);
//        model.addAttribute("cert", new Cert());
        return "/index";
    }

    @PostMapping("/cert/add" )
    public String saveCert(Model model, @ModelAttribute Cert cert, @RequestParam("category") Long id){

        Category category = categoryService.findById(id);
        cert.setCategory(category);
        certService.save(cert);
        model.addAttribute("cert", new Cert());
        return "redirect:/cert";

    }

    @PostMapping("/cert/delete/{id}")
    public String deleteCert(@PathVariable("id") String id){
        certService.delete(id);
        return "redirect:/cert";
    }
}
