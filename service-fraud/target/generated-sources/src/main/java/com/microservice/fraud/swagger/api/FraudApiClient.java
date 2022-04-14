package com.microservice.fraud.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.microservice.fraud.swagger.config.ClientConfiguration;

@FeignClient(name="${fraud.name:fraud}", url="${fraud.url:http://localhost:8082}", configuration = ClientConfiguration.class)
public interface FraudApiClient extends FraudApi {
}
