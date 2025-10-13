package org.example.service;

import org.example.entity.Person;

public interface AtchasService {
    Person testWatch(Person person);

    void testTrace();

    void testStack(String id);

    void testTt(String id);
}
