package com.example.springfinaltest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cert {
    @Id
    private String id;

    @Column
    private String cert_name;

    @Column
    private double cost;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
