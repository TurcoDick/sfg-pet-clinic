package com.alsinteligence.sfgpetclinic.services.map;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    Owner owner;
    Set<Pet> pets = new HashSet<>();
    Pet pet1 = new Pet();
    Pet pet2 = new Pet();
    PetType petType = new PetType();
    Long idOwner = 1L;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());


        pet1.setName("Dick");
        petType.setName("dog");
        pet1.setPetType(petType);
        pet1.setOwner(owner);
        pet1.setId(2L);

        pet2.setName("Jade");
        pet2.setPetType(petType);
        pet2.setOwner(owner);
        pet2.setId(2L);

        pets.add(pet1);
        pets.add(pet2);

        owner.setTelephone("36623384");
        owner.setCity("Campos do Jordão");
        owner.setAddress("Rua Davos");
        owner.setFirstName("Alison");
        owner.setLastName("lucio");
        owner.setPets(pets);

        owner.setId(idOwner);

    }

    @Test
    void save() {
        ownerMapService.save(owner);
        Owner ownerSave = ownerMapService.findByLastName("Lucio");
        Assertions.assertEquals("Alison", ownerSave.getFirstName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        Assertions.assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
        Owner ownerFindById = ownerMapService.findById(idOwner);
        Assertions.assertEquals(idOwner, ownerFindById.getId());
    }

    @Test
    void delete() {
    }



    @Test
    void findByLastName() {
    }
}