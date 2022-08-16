package com.cloudsitos.calculadora_java_api.models;

public class calculateRequestModel {
    
    private String operation;

    public calculateRequestModel() {
    }

    public calculateRequestModel(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
