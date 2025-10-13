package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Person;
import org.example.service.AtchasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ArthasController {

    @Autowired
    private AtchasService atchasService;

    @PostMapping("testWatch")
    public Person testWatch(@RequestBody Person person) {
        return atchasService.testWatch(person);
    }

    @GetMapping("testTrace")
    public void testTrace() {
        atchasService.testTrace();
    }

    @GetMapping("testStack")
    public void testStack(String id) {
        atchasService.testStack(id);
    }

    @GetMapping("testTt")
    public void testTt(String id) {
        atchasService.testTt(id);
    }
}
