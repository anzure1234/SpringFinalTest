package com.example.springfinaltest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, unique = true)
    private String name;

    @Column
    private String descriptions;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Cert> cert;
}
