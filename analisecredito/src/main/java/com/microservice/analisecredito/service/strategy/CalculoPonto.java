package com.microservice.analisecredito.service.strategy;

import com.microservice.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
