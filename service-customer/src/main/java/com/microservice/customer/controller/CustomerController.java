package com.microservice.customer.controller;

import com.microservice.customer.service.CustomerService;
import com.microservice.customer.swagger.api.CustomerApi;
import com.microservice.customer.swagger.model.CustomerRequest;
import com.microservice.customer.swagger.model.CustomerResponse;
import com.microservice.customer.swagger.model.CustomerResponseNoMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        log.info("New customer: {}", customerRequest);
        return service.saveCustomer(customerRequest);
    }

    @Override
    public ResponseEntity<List<CustomerResponseNoMessage>> getAllCustomers() {
        return service.getAllCustomers();
    }

}
