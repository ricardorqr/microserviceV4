package com.microservice.customer.controller;

import com.microservice.customer.service.CustomerService;
import com.spring.swagger.codegen.api.CustomersApi;
import com.spring.swagger.codegen.model.CustomerRequest;
import com.spring.swagger.codegen.model.CustomerResponse;
import com.spring.swagger.codegen.model.CustomerResponseNoMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class CustomerController implements CustomersApi {

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
