package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TestFeign2", url = "localhost:8082")
public interface TestFeignBack {

    @GetMapping("/user/{id}")
    String testFeign(String id);

    @GetMapping("/testException2")
    String testException2();
}