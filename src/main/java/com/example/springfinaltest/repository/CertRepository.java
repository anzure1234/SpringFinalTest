package com.example.springfinaltest.repository;


import com.example.springfinaltest.entity.Cert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CertRepository extends BaseRepository<Cert,String>{
    long countByCategory_Id(int categoryId);

}
