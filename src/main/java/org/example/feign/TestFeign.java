package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TestFeign", url = "localhost:8082", fallback = TestFeignFallBack.class)
public interface TestFeign {

    @GetMapping("/user/{id}")
    String testFeign(String id);

    @GetMapping("/testException")
    String testException();

    @GetMapping(value = "/testNormalFeign", name = "a")
    String testNormal();
}