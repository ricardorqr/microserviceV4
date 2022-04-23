package com.microservice.customer.service;

import com.microservice.clients.notification.NotificationRequest;
import com.microservice.clients.swagger.customer.model.CustomerRequest;
import com.microservice.clients.swagger.customer.model.CustomerResponse;
import com.microservice.clients.swagger.customer.model.CustomerResponseNoMessage;
import com.microservice.clients.swagger.fraud.api.FraudApiClient;
import com.microservice.customer.model.Customer;
import com.microservice.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudApiClient api;
    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    public ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.getFirstName())
                                    .lastName(customerRequest.getLastName())
                                    .email(customerRequest.getEmail())
                                    .build();
        repository.saveAndFlush(customer);

        // Fraud service
        ResponseEntity<Boolean> fraudCheckResponse = api.isFraudster(customer.getId());
        log.info("Fraud response: {}", fraudCheckResponse.getBody());

        if (!fraudCheckResponse.getStatusCode()
                               .equals(HttpStatus.OK)) {
            throw new IllegalStateException("ERROR: Not HTTP 200");
        }

        NotificationRequest notificationRequest = NotificationRequest.builder()
                                                                     .toCustomerId(customer.getId())
                                                                     .toCustomerName(customer.getEmail())
                                                                     .message(String.format("Hi %s, How are you?", customer.getFirstName()))
                                                                     .build();

        // Notification service
        kafkaTemplate.send("customerKafkaTopic", notificationRequest);
        log.info("Publishing the message: {}", notificationRequest);

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

}
