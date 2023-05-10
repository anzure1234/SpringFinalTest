package com.example.springfinaltest.service.impl;

import com.example.springfinaltest.entity.Cert;
import com.example.springfinaltest.repository.CertRepository;
import com.example.springfinaltest.service.CertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CertServiceImpl implements CertService {
    private final CertRepository certRepository;

    public CertServiceImpl(CertRepository certRepository) {
        this.certRepository = certRepository;
    }

    @Override
    public void save(Cert cert) {
        certRepository.save(cert);

    }

    @Override
    public void delete(String id) {
        certRepository.deleteById(id);

    }

    @Override
    public Page<Cert> findAllPaging(Specification<Cert> specification, Pageable pageable) {
        return certRepository.findAll(specification, pageable);
    }

    @Override
    public Optional<Cert> findById(String id) {
        return certRepository.findById(id);
    }


}
