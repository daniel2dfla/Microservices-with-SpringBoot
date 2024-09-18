package com.microservices.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalRequestDto {

    private String name;

    private String lastName;

    private String cellphone;

    private String cpf;

    private Double rent;

    private Double requestedAmount;

    private int datePaymentLimit;
}
