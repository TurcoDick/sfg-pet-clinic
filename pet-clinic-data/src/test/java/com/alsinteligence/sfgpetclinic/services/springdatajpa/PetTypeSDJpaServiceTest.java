package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetTypeSDJpaServiceTest {

    private static final String TYPE_DOG = "Dog";
    private static final String TYPE_CAT = "Cat";
    private static final String TYPE_FISH = "Fish";
    @Mock
    PetTypeSDJpaService service;

    Set<PetType> petTypes = new HashSet<>();

    PetType petTypeDog = new PetType(1L, TYPE_DOG);
    PetType petTypeCat = new PetType(2L, TYPE_CAT);
    PetType petTypeFish = new PetType(3L, TYPE_FISH);

    @BeforeEach
    void setUp() {
        petTypes.add(petTypeCat);
        petTypes.add(petTypeDog);
        petTypes.add(petTypeFish);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(petTypes);
        Set<PetType> petTypes = service.findAll();
        assertEquals(3,petTypes.size());
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(petTypeCat);
        PetType petType = service.findById(1L);
        assertEquals(TYPE_CAT, petType.getName());
    }

    @Test
    void save() {
        when(service.save(petTypeDog)).thenReturn(petTypeDog);
        PetType petType = service.save(petTypeDog);
        assertEquals(TYPE_DOG, petType.getName());
    }

    @Test
    void delete() {
        service.delete(petTypeDog);
        Mockito.verify(service).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        Mockito.verify(service).deleteById(1L);
    }
}