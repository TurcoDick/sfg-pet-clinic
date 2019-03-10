package com.alsinteligence.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void groupedAssertions(){
        //given
        Person person = new Person(1L,"Alison","Lucio");

        //then
        assertAll("Test props setting",
                ()-> assertEquals("Alison",person.getFirstName()),
                ()-> assertEquals("Lucio",person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs(){
        //given
        Person person = new Person(1L,"Alison","Lucio");

        //then
        assertAll("Test props setting",
                ()-> assertEquals("Alison",person.getFirstName(),"Error in fistName"),
                ()-> assertEquals("Lucio",person.getLastName(),"Error in lastName"));
    }

}