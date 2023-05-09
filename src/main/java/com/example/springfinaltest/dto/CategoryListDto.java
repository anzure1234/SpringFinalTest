package com.example.springfinaltest.dto;

import com.example.springfinaltest.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CategoryListDto {

    private int id;

    private String name;


    private String descriptions;


    private Set<Category> categories;

}
