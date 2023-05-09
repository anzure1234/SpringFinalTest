package com.example.springfinaltest.service.impl;

import com.example.springfinaltest.entity.Cert;
import com.example.springfinaltest.repository.CertRepository;
import com.example.springfinaltest.service.CertService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Cert> showAll() {
        return (List<Cert>) certRepository.findAll();
    }
}
