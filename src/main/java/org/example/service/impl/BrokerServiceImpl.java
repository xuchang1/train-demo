package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.feign.TestFeign;
import org.example.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private TestFeign testFeign;

    private AtomicInteger i = new AtomicInteger();

    @Override
    public String testBroker() {
        log.info("请求次数 ：{}", i.incrementAndGet());
        return testFeign.testException();
    }
}
