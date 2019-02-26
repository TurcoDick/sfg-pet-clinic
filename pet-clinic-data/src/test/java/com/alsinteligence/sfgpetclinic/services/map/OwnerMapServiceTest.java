package com.alsinteligence.sfgpetclinic.services.map;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.model.PetType;
import com.alsinteligence.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerMapServiceTest {

    public static final String LAST_NAME_ALISON = "Lucio";

    @Mock
    OwnerMapService service;


    Set<Pet> pets = new HashSet<>();
    PetType petTypeDog = new PetType("Dog");

    Owner owner1 = new Owner(1L,"Alison", "Lucio","Rua Davos",
            "Campos do Jordão","36623384", new HashSet<Pet>());

    Owner owner2 = new Owner(2L,"Fernanda", "Montero","Rua Davos",
            "Campos do Jordão","36623384", new HashSet<Pet>());

    Owner ownerSave = new Owner(3L,"Camila","Juan", "Rua Venesa",
            "Campos do Jordão","36625586",new HashSet<Pet>());

    Pet pet1 = new Pet(1L,"Dick",petTypeDog,owner1, new HashSet<Visit>());
    Pet pet2 = new Pet(2L,"Jade",petTypeDog,owner2, new HashSet<Visit>());

    Set<Owner> returnOwnersSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        owner1.getPets().add(pet1);
        owner1.getPets().add(pet2);
        owner2.getPets().add(pet1);
        owner2.getPets().add(pet2);
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findAllNotPass() {
        when(service.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertFalse(owners.size() != 2);
    }

    @Test
    void deleteById() {
        service.delete(owner1);
        Mockito.verify(service).delete(any());
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(owner1);
        Owner owner = service.findById(1L);
        assertEquals("Lucio", owner.getLastName());
    }

    @Test
    void save() {
        when(service.save(ownerSave)).thenReturn(ownerSave);
        Owner owner = service.save(ownerSave);
        assertEquals("Juan", owner.getLastName());
    }

    @Test
    void delete() {
        service.delete(owner1);
        Mockito.verify(service).delete(any());
    }

    @Test
    void findByLastName() {
        when(service.findByLastName(any())).thenReturn(owner1);
        Owner owner = service.findByLastName(LAST_NAME_ALISON);
        assertEquals(LAST_NAME_ALISON, owner.getLastName());
    }
}