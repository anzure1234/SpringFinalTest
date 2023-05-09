package com.example.springfinaltest.controller;


import com.example.springfinaltest.dto.CertListDto;
import com.example.springfinaltest.service.CertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CertController {

    @GetMapping("/cert")
    public String showCart(Model model) {
        model.addAttribute("certList",new CertListDto());
        return "/index";
    }


}
