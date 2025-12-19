package org.example.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class TestFeignFallBack implements TestFeign {

    @Autowired
    private TestFeignBack testFeignBack;

    private AtomicInteger i = new AtomicInteger();

    @Override
    public String testFeign(String id) {
        return testFeignBack.testFeign(id);
    }

    @Override
    public String testException() {
        log.info("failback次数 ：{}", i.incrementAndGet());
        return testFeignBack.testException2();
    }
}
