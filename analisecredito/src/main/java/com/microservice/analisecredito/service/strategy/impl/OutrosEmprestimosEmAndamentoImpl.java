package com.microservice.analisecredito.service.strategy.impl;

import com.microservice.analisecredito.domain.Proposta;
import com.microservice.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
