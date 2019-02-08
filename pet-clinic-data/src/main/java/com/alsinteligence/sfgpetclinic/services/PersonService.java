package com.alsinteligence.sfgpetclinic.services;

import com.alsinteligence.sfgpetclinic.model.Person;

import java.util.Set;

public interface PersonService {

    Person findById(Long id);

    Person save(Person owner);

    Set<Person> findAll();
}
