package com.example.springfinaltest.controller;


import com.example.springfinaltest.constant.AppConstant;
import com.example.springfinaltest.dto.CertListDto;
import com.example.springfinaltest.entity.Category;
import com.example.springfinaltest.entity.Cert;
import com.example.springfinaltest.service.CategoryService;
import com.example.springfinaltest.service.CertService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        model.addAttribute("certListDto", new CertListDto());
        return "/index";
    }


    @PostMapping("/cert/add" )
    public String saveCert(Model model,@Valid @ModelAttribute CertListDto certListDto, @RequestParam("category") Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/cert";
        }
        if(certListDto.getId().isEmpty()){
            bindingResult.rejectValue("id", "cert.id.not.empty");
        }
        if(certListDto.getCert_name().isEmpty()){
            bindingResult.rejectValue("name", "cert.name.not.empty");
        }
        if (bindingResult.hasErrors()) {
            return "redirect:/cert";
        }

        Cert cert = new Cert();
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            BeanUtils.copyProperties(certListDto, cert);
            cert.setCategory(category);
            certService.save(cert);
            model.addAttribute("certListDto", new CertListDto());
        }
        return "redirect:/cert";

    }

    @PostMapping("/cert/delete/{id}")
    public String deleteCert(@PathVariable("id") String id){
        certService.delete(id);
        return "redirect:/cert";
    }

    @PostMapping("/cert/edit/{id}")
    public String update(@PathVariable("id") String id, @Valid CertListDto certListDto, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/cert";
        }
        Optional<Cert> certOptional = certService.findById(id);
        if(certOptional.isPresent()){
        Cert cert = certOptional.get();
        BeanUtils.copyProperties(certListDto, cert);
        certService.save(cert);
        return "redirect:/cert";
        }
        return "redirect:/cert";
    }

    @GetMapping("/cert/classify")
    @ResponseBody
    public List<Map<String, Object>> getClassify() {
        return categoryService.getCategoryStats();
    }

}
