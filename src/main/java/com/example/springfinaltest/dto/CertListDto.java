package com.example.springfinaltest.dto;

import com.example.springfinaltest.entity.Cert;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertListDto {
    @NotBlank(message = "{common.error.required}")
    private String id;


    private String cert_name;

    private double cost;


    private Cert cert;
}
