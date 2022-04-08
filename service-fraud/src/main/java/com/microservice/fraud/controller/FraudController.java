package com.microservice.fraud.controller;

import com.microservice.fraud.service.FraudService;
import com.spring.swagger.codegen.api.FraudApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class FraudController implements FraudApi {

    private final FraudService service;

    @Override
    public ResponseEntity<Boolean> isFraudster(Integer customerId) {
        log.info("Fraud check request for the customer: {}", customerId);
        return new ResponseEntity<>(service.isFraudulentCustomer(customerId), HttpStatus.OK);
    }

}
