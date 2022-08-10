package com.cloudsitos.calculadora_java_api.models;

public class calculateRequestModelRest {
    
    private final String operation;

    public calculateRequestModelRest(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

}
