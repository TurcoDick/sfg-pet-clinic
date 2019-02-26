package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Speciality;
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
class SpecialitySDJpaServiceTest {

    private static final String DESCRITION_CIRURGIC = "Cirurgic";
    private static final String DESCRITION_RADIOLOGIC = "Radiologic";

    @Mock
    SpecialitySDJpaService service;

    Speciality specialityRadiologicy = new Speciality();
    Speciality specialityCirurgic = new Speciality();

    Set<Speciality> specialities = new HashSet<>();

    @BeforeEach
    void setUp() {
        specialityCirurgic.setId(1L);
        specialityCirurgic.setDescription(DESCRITION_CIRURGIC);
        specialities.add(specialityCirurgic);

        specialityRadiologicy.setId(2L);
        specialityRadiologicy.setDescription(DESCRITION_RADIOLOGIC);
        specialities.add(specialityRadiologicy);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(specialities);
        Set<Speciality> specialities = service.findAll();
        assertEquals(2, specialities.size());
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(specialityCirurgic);
        Speciality speciality = service.findById(1L);
        assertEquals(DESCRITION_CIRURGIC,speciality.getDescription());
    }

    @Test
    void save() {
        when(service.save(specialityRadiologicy)).thenReturn(specialityRadiologicy);
        Speciality speciality = service.save(specialityRadiologicy);
        assertEquals(DESCRITION_RADIOLOGIC, speciality.getDescription());
    }

    @Test
    void delete() {
        service.delete(specialityRadiologicy);
        Mockito.verify(service).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(specialityRadiologicy.getId());
        Mockito.verify(service).deleteById(specialityRadiologicy.getId());
    }
}