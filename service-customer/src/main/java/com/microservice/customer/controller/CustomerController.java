package com.microservice.customer.controller;

import com.microservice.clients.swagger.customer.api.CustomerApi;
import com.microservice.clients.swagger.customer.model.CustomerRequest;
import com.microservice.clients.swagger.customer.model.CustomerResponse;
import com.microservice.clients.swagger.customer.model.CustomerResponseNoMessage;
import com.microservice.customer.service.CustomerService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService service;

    @Override
    @Retry(name = "customerAddCustomer", fallbackMethod = "serviceAFallback")
    public ResponseEntity<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        log.info("New customer: {}", customerRequest);
        return service.saveCustomer(customerRequest);
    }

    @Override
    public ResponseEntity<List<CustomerResponseNoMessage>> getAllCustomers() {
        ResponseEntity<List<CustomerResponseNoMessage>> allCustomers = service.getAllCustomers();
        if (allCustomers.getBody() != null) {
            log.info("All customers: {}", allCustomers.getBody().size());
            return allCustomers;
        }
        return new ResponseEntity<>(new ArrayList<CustomerResponseNoMessage>(), HttpStatus.OK);
    }

    public ResponseEntity<String> serviceAFallback(Exception e) {
        return new ResponseEntity<>("This is a fallback method from customer", HttpStatus.OK);
    }

}
