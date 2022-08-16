package com.cloudsitos.calculadora_java_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsitos.calculadora_java_api.libraries.Math;
import com.cloudsitos.calculadora_java_api.models.calculateRequestModel;
import com.cloudsitos.calculadora_java_api.models.calculateResponseModel;

@RestController
@RequestMapping(value = "api/calculator")
public class calculatorController {
    
    @GetMapping(value = "/heartbeat")
    public ResponseEntity<String> heartbeat(){
        return ResponseEntity.status(HttpStatus.OK).body("Successful connection");
    }

    @PostMapping(value = "/calculate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<calculateResponseModel> calculate(@RequestBody calculateRequestModel request){
        String operation = request.getOperation().toString();
        Integer response =  Math.calculate(operation);
        return new ResponseEntity<>(
                    new calculateResponseModel(operation, response.toString(), "fdsf"),
                    HttpStatus.OK
                );
    
    }

}
