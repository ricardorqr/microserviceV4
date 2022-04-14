package com.microservice.customer.swagger.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.microservice.customer.swagger.config.ClientConfiguration;

@FeignClient(name="${customer.name:customer}", url="${customer.url:http://localhost:8081}", configuration = ClientConfiguration.class)
public interface CustomerApiClient extends CustomerApi {
}
