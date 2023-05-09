package com.example.springfinaltest.service;

import com.example.springfinaltest.entity.Cert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CertService {
    void save(Cert cert);

    void delete(String id);

    Page<Cert> findAllPaging(Specification<Cert> specification, Pageable pageable);


}
