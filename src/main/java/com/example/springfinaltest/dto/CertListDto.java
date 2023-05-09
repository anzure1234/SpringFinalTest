package com.example.springfinaltest.dto;

import com.example.springfinaltest.entity.Cert;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertListDto {
    private String id;


    private String cert_name;


    private double cost;


    private Cert cert;
}
