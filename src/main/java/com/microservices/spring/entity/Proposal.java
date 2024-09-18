package com.microservices.spring.entity;

import jakarta.persistence.*;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestedAmount;

    private int datePaymentLimit;

    private Boolean approved;

    private Boolean integrated;

    private String observation;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
