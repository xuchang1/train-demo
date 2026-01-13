package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    @GetMapping("testBroker")
    public String testBroker() {
        try {
            return brokerService.testBroker();
        } catch (Exception e) {
            log.error("异常 : {}", e.getMessage(), e);
            return e.getMessage();
        }
    }

    @GetMapping("testNormal")
    public String testNormal() {
        return brokerService.testNormal();
    }
}
