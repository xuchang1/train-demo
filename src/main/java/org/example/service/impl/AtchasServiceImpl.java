package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Person;
import org.example.service.AtchasService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AtchasServiceImpl implements AtchasService {
    @Override
    public Person testWatch(Person person) {
        Person result = new Person();
        result.setId("2");
        result.setName(person.getName());
        return result;
    }

    @Override
    public void testTrace() {
        method1();
        method2();
        method3();
    }

    @Override
    public void testStack(String id) {
        if ("1".equals(id)) {
            testStack1();
        } else if ("2".equals(id)) {
            testStack2();
        } else {
            testStack3();
        }
    }

    @Override
    public void testTt(String id) {
        if ("1".equals(id)) {
            throw new RuntimeException("异常");
        } else {
            method1();
        }
    }

    private void testStack3() {
        method1();
        method3();
    }

    private void testStack2() {
        method2();
    }

    private void testStack1() {
        method1();
    }

    private void method3() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    private void method2() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }
    }

    private void method1() {
        try {
            Thread.sleep(200);
            log.info("do method1");
        } catch (InterruptedException e) {

        }
    }
}
