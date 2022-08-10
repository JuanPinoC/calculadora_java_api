package com.cloudsitos.calculadora_java_api.models;

public class calculateResponseModel {
    
    private String operation;
    private String response;
    private String response_time;

    public calculateResponseModel(String operation, String response, String response_time) {
        this.operation = operation;
        this.response = response;
        this.response_time = response_time;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getResponse_time() {
        return response_time;
    }
    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

}
