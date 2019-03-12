package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Speciality;
import com.alsinteligence.sfgpetclinic.model.Vet;
import com.alsinteligence.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    private static final String DESCRITION_RADIOLOGISTIC = "Radiologic";
    private static final String DESCRITION_CIRURGIC = "Cirurgic";

    Set<Vet> vetSet;
    Set<Speciality> specialities;
    Speciality specialityRadiologic;
    Speciality specialityCirurgic;

    Vet vetCamila;
    Vet vetRoberto;

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    @BeforeEach
    void setUp() {

        vetSet = new HashSet<>();
        specialities = new HashSet<>();
        specialityRadiologic = new Speciality(1L, DESCRITION_RADIOLOGISTIC);
        specialityCirurgic = new Speciality(2L, DESCRITION_CIRURGIC);

        vetCamila = new Vet(1L,specialities);
        vetRoberto = new Vet(2L, specialities);

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
        when(vetRepository.findById(1L)).thenReturn(Optional.of(vetCamila));
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
        service.delete(new Vet());
        verify(vetRepository).delete(any(Vet.class));
    }

    @Test
    void deleteById() {
        service.deleteById(vetCamila.getId());
        verify(vetRepository).deleteById(vetCamila.getId());
    }
}