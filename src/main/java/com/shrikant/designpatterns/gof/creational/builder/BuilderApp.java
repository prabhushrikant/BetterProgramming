package com.shrikant.designpatterns.gof.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuilderApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuilderApp.class);

    public static void main(String[] args) {

        Person person = Person.builder()
            .name("Shrikant").age(41).build();

        LOGGER.info("Person object was created using builder pattern with name - {}.", 
        person.getName());
    }
}
