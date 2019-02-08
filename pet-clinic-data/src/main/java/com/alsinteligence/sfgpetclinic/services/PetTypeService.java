package com.alsinteligence.sfgpetclinic.services;

import com.alsinteligence.sfgpetclinic.model.PetType;

import java.util.Set;

public interface PetTypeService {

    PetType findById(Long id);

    PetType save(PetType petType);

    Set<PetType> findAll();
}
