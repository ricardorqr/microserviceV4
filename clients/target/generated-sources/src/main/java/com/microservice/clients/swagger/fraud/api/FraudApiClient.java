package com.microservice.clients.swagger.fraud.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.microservice.clients.swagger.fraud.config.ClientConfiguration;

@FeignClient(name="${fraud.name:fraud}", url="${fraud.url:http://localhost:8082}", configuration = ClientConfiguration.class)
public interface FraudApiClient extends FraudApi {
}
