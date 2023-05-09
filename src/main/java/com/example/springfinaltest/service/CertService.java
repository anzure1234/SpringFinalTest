package com.example.springfinaltest.service;

import com.example.springfinaltest.entity.Cert;

import java.util.List;

public interface CertService {
    void save(Cert cert);

    void delete(String id);

    List<Cert> showAll();
}
