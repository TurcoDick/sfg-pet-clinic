package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Speciality;
import com.alsinteligence.sfgpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    private static final String DESCRITION_RADIOLOGISTIC = "Radiologic";
    private static final String DESCRITION_CIRURGIC = "Cirurgic";
    Set<Vet> vetSet = new HashSet<>();
    Set<Speciality> specialities = new HashSet<>();
    Speciality specialityRadiologic = new Speciality(1L, DESCRITION_RADIOLOGISTIC);
    Speciality specialityCirurgic = new Speciality(2L, DESCRITION_CIRURGIC);

    Vet vetCamila = new Vet(1L,specialities);
    Vet vetRoberto = new Vet(2L, specialities);

    @Mock
    VetSDJpaService service;

    @BeforeEach
    void setUp() {
        specialities.add(specialityCirurgic);
        specialities.add(specialityRadiologic);
        vetSet.add(vetCamila);
        vetSet.add(vetRoberto);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(vetSet);
        Set<Vet> vets = service.findAll();
        assertEquals(2,vets.size());
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(vetCamila);
        Vet vet = service.findById(vetCamila.getId());
        assertEquals(vetCamila.getId(), vet.getId());
    }

    @Test
    void save() {
        when(service.save(vetRoberto)).thenReturn(vetRoberto);
        Vet vet = service.save(vetRoberto);
        assertEquals(vetRoberto.getFirstName(), vet.getFirstName());
    }

    @Test
    void delete() {
        service.delete(vetRoberto);
        Mockito.verify(service).delete(vetRoberto);
    }

    @Test
    void deleteById() {
        service.deleteById(vetCamila.getId());
        Mockito.verify(service).deleteById(vetCamila.getId());
    }
}