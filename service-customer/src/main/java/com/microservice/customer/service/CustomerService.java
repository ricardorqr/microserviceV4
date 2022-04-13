package com.microservice.customer.service;

import com.microservice.customer.model.Customer;
import com.microservice.customer.repository.CustomerRepository;
import com.spring.swagger.codegen.api.FraudApiClient;
import com.spring.swagger.codegen.model.CustomerRequest;
import com.spring.swagger.codegen.model.CustomerResponse;
import com.spring.swagger.codegen.model.CustomerResponseNoMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudApiClient api;

    public ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.getFirstName())
                                    .lastName(customerRequest.getLastName())
                                    .email(customerRequest.getEmail())
                                    .build();
        repository.saveAndFlush(customer);


        ResponseEntity<Boolean> fraudCheckResponse = api.isFraudster(customer.getId());

        if (!fraudCheckResponse.getStatusCode()
                               .equals(HttpStatus.OK)) {
            throw new IllegalStateException("ERROR: Not HTTP 200");
        }

        return new ResponseEntity<>(changeBookToBookResponse(customer, "Customer inserted successfully"), HttpStatus.OK);
    }

    public ResponseEntity<List<CustomerResponseNoMessage>> getAllCustomers() {
        List<Customer> books = repository.findAll();
        List<CustomerResponseNoMessage> customerResponses = books.stream()
                                                                 .map(this::changeBookToBookResponseNoMessage)
                                                                 .collect(Collectors.toList());
        return new ResponseEntity<>(customerResponses, HttpStatus.OK);
    }

    private CustomerResponseNoMessage changeBookToBookResponseNoMessage(Customer customer) {
        CustomerResponseNoMessage response = new CustomerResponseNoMessage();
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());
        return response;
    }

    private CustomerResponse changeBookToBookResponse(Customer customer, String message) {
        CustomerResponse response = new CustomerResponse();
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());
        response.setMessage(message);
        return response;
    }

//    private final FraudClient fraudClient;  // Sync message
//    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate; // Async message

//    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
//        Customer customerSaved = repository.saveAndFlush(Customer.builder()
//                                                                 .firstName(customerRequest.getFirstName())
//                                                                 .lastName(customerRequest.getLastName())
//                                                                 .email(customerRequest.getEmail())
//                                                                 .build());
//
//        // Client service
//        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customerSaved.getId());
//
//        if (fraudCheckResponse.isFraudster()) {
//            throw new IllegalStateException("Fraudster");
//        }
//
//        NotificationRequest notificationRequest = NotificationRequest.builder()
//                                                                     .toCustomerId(customerSaved.getId())
//                                                                     .toCustomerName(customerSaved.getEmail())
//                                                                     .message(String.format("Hi %s, How are you?", customerSaved.getFirstName()))
//                                                                     .build();
//
//        // Notification service
//        kafkaTemplate.send("customerKafkaTopic", notificationRequest);
//        log.info("Publishing the message: {}", notificationRequest);
//
//        return CustomerResponse.builder()
//                               .firstName(customerSaved.getFirstName())
//                               .lastName(customerSaved.getLastName())
//                               .email(customerSaved.getEmail())
//                               .fraudulent(fraudCheckResponse.isFraudster())
//                               .build();
//    }
//
//    public List<CustomerResponse> getAll() {
//        return repository.findAll()
//                         .stream()
//                         .map(customer -> {
//                             FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
//                             return CustomerResponse.builder()
//                                                    .firstName(customer.getFirstName())
//                                                    .lastName(customer.getLastName())
//                                                    .email(customer.getEmail())
//                                                    .fraudulent(fraudCheckResponse.isFraudster())
//                                                    .build();
//                         })
//                         .collect(Collectors.toList());
//    }

}