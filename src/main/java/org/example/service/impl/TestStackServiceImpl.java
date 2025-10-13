package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Person;
import org.example.mapper.PersonMapper;
import org.example.service.TestStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestStackServiceImpl implements TestStackService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public void testException() {
        throw new RuntimeException();
    }

    @Override
    public void testStop() {
        String a = "a";
        synchronized (a) {
            try {
                a.wait();
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public Person testPgStop() {
        return personMapper.selectById("1");
    }

    @Override
    public String testFeign(String id) {
        return id;
    }

    @Override
    public void test(String id) {
        log.info("do test");
    }
}