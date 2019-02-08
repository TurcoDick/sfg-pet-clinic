package com.alsinteligence.sfgpetclinic.services;

import com.alsinteligence.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
