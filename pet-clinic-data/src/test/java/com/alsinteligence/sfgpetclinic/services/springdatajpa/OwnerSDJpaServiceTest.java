package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.model.PetType;
import com.alsinteligence.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME_ALISON = "Lucio";

    @Mock
    OwnerSDJpaService service;

    Set<Pet> pets;
    Set<Owner> returnOwnersSet;
    PetType petTypeDog;
    Owner owner1, owner2;
    Pet pet1, pet2;


    @BeforeEach
    void setUp() {

        pets = new HashSet<>();
        returnOwnersSet = new HashSet<>();
        petTypeDog = new PetType("Dog");
        owner1 = new Owner(1L,"Alison", "Lucio","Rua Davos","Campos do Jordão","36623989", new HashSet<Pet>());
        owner2 = new Owner(2L,"Fernanda", "Montero","Rua Davos","Campos do Jordão","36623989", new HashSet<Pet>());
        pet1 = new Pet(1L, "Dick",petTypeDog,owner1, new HashSet<Visit>());
        pet2 = new Pet(2L, "Jade",petTypeDog,owner2, new HashSet<Visit>());


        owner1.getPets().add(pet1);
        owner1.getPets().add(pet2);
        owner2.getPets().add(pet1);
        owner2.getPets().add(pet2);
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);
    }

    @Test
    void findByLastName() {
        when(service.findByLastName(any())).thenReturn(owner1);
        Owner lucio = service.findByLastName(LAST_NAME_ALISON);
        Assertions.assertEquals(LAST_NAME_ALISON,lucio.getLastName());
        Mockito.verify(service).findByLastName(any());
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(owner1);
        Owner owner = service.findById(1L);
        assertNotNull(owner);
        assertEquals("Alison", owner.getFirstName());
    }

    @Test
    void save() {
        when(service.save(owner1)).thenReturn(owner1);
        Owner owner = service.save(owner1);
        assertNotNull(owner);
        assertEquals("Lucio",owner.getLastName());
    }

    @Disabled  // desativar este teste
    @Test
    void delete() {
        service.delete(owner1);
        Mockito.verify(service).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        Mockito.verify(service).deleteById(1L);
    }
}