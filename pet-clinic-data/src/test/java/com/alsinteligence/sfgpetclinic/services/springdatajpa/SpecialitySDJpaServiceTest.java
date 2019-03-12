package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Speciality;
import com.alsinteligence.sfgpetclinic.repositories.SpecialityRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialitySDJpaService service;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(new HashSet<Speciality>());
        Set<Speciality> specialities = service.findAll();
        assertEquals(0, specialities.size());
    }

    @Test
    void findById() {

        Speciality speciality = new Speciality(1L,"arroz");

        when(specialityRepository.findById(1L)).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1L);

        assertEquals("arroz",foundSpeciality.getDescription());

        verify(specialityRepository).findById(anyLong());

    }

    @Test
    void save() {
        Speciality speciality = new Speciality(1L, "Jupter");
        when(service.save(speciality)).thenReturn(speciality);
        Speciality foundSpeciality = service.save(speciality);
        assertEquals("Jupter", foundSpeciality.getDescription());
        verify(specialityRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(new Speciality());
        verify(specialityRepository).delete(any(Speciality.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(specialityRepository, times(1)).deleteById(1L);
    }
}