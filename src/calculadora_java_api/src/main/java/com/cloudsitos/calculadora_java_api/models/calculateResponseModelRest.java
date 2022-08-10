package com.cloudsitos.calculadora_java_api.models;

public class calculateResponseModelRest {
    
    private String operation;
    private String response;
    private String response_time;

    public calculateResponseModelRest(String operation, String response, String response_time) {
        this.operation = operation;
        this.response = response;
        this.response_time = response_time;
    }

    public String getOperation() {
        return operation;
    }

    public String getResponse() {
        return response;
    }

    public String getResponse_time() {
        return response_time;
    }

}
