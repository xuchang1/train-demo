package org.example.service;

import org.example.entity.Person;

import java.util.List;

public interface PageService {
    List<Person> queryByPage();
}
