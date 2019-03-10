package com.alsinteligence.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {

    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1L,"Debora","Lara");
        owner.setCity("Taubaté");
        owner.setTelephone("12123214");

        assertAll("Properties Test",
                ()-> assertAll("Person properties",
                        ()-> assertEquals("Debora", owner.getFirstName(),"First Name Did not Match"),
                        ()-> assertEquals("Lara", owner.getLastName())),

                ()-> assertAll("Owner properties",
                        ()-> assertEquals("Taubaté",owner.getCity(),"City Did Not Match"),
                        ()-> assertEquals("12123214", owner.getTelephone())
                ));
    }

}