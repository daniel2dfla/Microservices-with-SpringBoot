package com.microservice.analisecredito.exceptions;

public class StrategyException extends RuntimeException{

    public StrategyException(String mensagem) {
        super(mensagem);
    }
}
