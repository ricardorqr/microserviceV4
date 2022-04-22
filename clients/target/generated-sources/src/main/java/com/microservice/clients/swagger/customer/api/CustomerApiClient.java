package com.microservice.clients.swagger.customer.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.microservice.clients.swagger.customer.config.ClientConfiguration;

@FeignClient(name="${customer.name:customer}", url="${customer.url:http://localhost:8081}", configuration = ClientConfiguration.class)
public interface CustomerApiClient extends CustomerApi {
}
