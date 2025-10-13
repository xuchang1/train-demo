package org.example.service;

import org.example.entity.Person;

public interface TestStackService {
    void testException();

    void testStop();

    Person testPgStop();

    String testFeign(String id);

    void test(String id);
}
