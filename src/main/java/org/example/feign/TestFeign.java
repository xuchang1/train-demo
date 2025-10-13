package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TestFeign", url = "localhost:8081")
public interface TestFeign {

    @GetMapping("/user/{id}")
    String testFeign(String id);
}