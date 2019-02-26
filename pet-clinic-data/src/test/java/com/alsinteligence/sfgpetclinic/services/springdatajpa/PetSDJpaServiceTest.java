package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.model.PetType;
import com.alsinteligence.sfgpetclinic.model.Visit;
import com.alsinteligence.sfgpetclinic.services.PetService;
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
class PetSDJpaServiceTest {

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final String NAME_PET_1 = "Varpi";
    private static final String NAME_PET_2 = "Jurr";
    private static final String PET_TYPE = "Dog";
    private static final String FIRST_NAME = "Andre";
    private static final String LAST_NAME = "Borette";
    private static final String ADDRESS = "Rua Davos";
    private static final String CITY = "Campos do Jordão";
    private static final String TELEPHONE = "36623989";

    @Mock
    PetService petService;

    Set<Pet> pets = new HashSet<>();



    Pet pet1 = new Pet(ID_1, NAME_PET_1,
            new PetType(PET_TYPE),
            new Owner(1L, FIRST_NAME, LAST_NAME, ADDRESS,
                    CITY, TELEPHONE, new HashSet<Pet>()),
            new HashSet<Visit>());

    Pet pet2 = new Pet(ID_2, NAME_PET_2,
            new PetType(PET_TYPE),
            new Owner(1L, FIRST_NAME, LAST_NAME, ADDRESS,
                    CITY, TELEPHONE, new HashSet<Pet>()),
            new HashSet<Visit>());


    @BeforeEach
    void setUp() {
        pets.add(pet1);
        pets.add(pet2);
    }

    @Test
    void findAll() {
        when(petService.findAll()).thenReturn(pets);
        Set<Pet> petSet = petService.findAll();
        assertEquals(2, petSet.size());
    }

    @Test
    void findById() {
        when(petService.findById(ID_1)).thenReturn(pet1);
        Pet pet = petService.findById(ID_1);
        assertEquals(FIRST_NAME,pet.getOwner().getFirstName());
    }

    @Test
    void save() {
        when(petService.save(pet1)).thenReturn(pet1);
        Pet pet = petService.save(pet1);
        assertEquals(FIRST_NAME, pet.getOwner().getFirstName());
    }

    @Test
    void delete() {
        petService.delete(pet1);
        Mockito.verify(petService).delete(any());
    }

    @Test
    void deleteById() {
        petService.deleteById(ID_2);
        Mockito.verify(petService).deleteById(any());
    }
}