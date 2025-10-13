package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Person;
import org.example.service.TestStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestStackController {


    @Autowired
    private TestStackService testStackService;

    @GetMapping("test")
    public String test(String id ) {
        testStackService.test(id);
        return id;
    }

    @GetMapping("testException")
    public void testException() {
        testStackService.testException();
    }

    @GetMapping("testStop")
    public void testStop() {
        log.info("开始testStop方法");
        testStackService.testStop();
        log.info("结束testStop方法");
    }

    @GetMapping("testPgStop")
    public Person testPgStop() {
        log.info("开始testPgStop方法");
        Person result = testStackService.testPgStop();
        log.info("结束testPgStop方法");
        return result;
    }

    @GetMapping("testFeign")
    public String testFeign(String id) {
        log.info("开始testFeign方法");
        String result = testStackService.testFeign(id);
        log.info("结束testFeign方法");
        return result;
    }
}
