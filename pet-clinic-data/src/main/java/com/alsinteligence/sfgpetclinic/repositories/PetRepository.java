package com.alsinteligence.sfgpetclinic.repositories;

import com.alsinteligence.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Pet findByName(String name);
}
