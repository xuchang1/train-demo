package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Person;
import org.example.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PageController {

    @Autowired
    private PageService pageService;
    @GetMapping("queryByPage")
    public List<Person> queryByPage() {
        return pageService.queryByPage();
    }
}
