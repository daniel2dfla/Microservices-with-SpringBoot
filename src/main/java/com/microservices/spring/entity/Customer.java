package com.microservices.spring.entity;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String cpf;

    private String cellphone;

    private Double rent;

    @OneToOne(mappedBy = "customer")
    private Proposal proposal;

}
