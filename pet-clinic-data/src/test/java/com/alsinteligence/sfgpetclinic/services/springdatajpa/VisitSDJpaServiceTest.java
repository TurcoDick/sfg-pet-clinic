package com.alsinteligence.sfgpetclinic.services.springdatajpa;

import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.model.Visit;
import com.alsinteligence.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    Set<Visit> visits;
    Visit visitDebora;
    Visit visitFabiola;

    @BeforeEach
    void setUp() {
        visits = new HashSet<>();
        visitDebora = new Visit(1L,LocalDate.now(),"visinha",new Pet());
        visitFabiola = new Visit(2L,LocalDate.now(),"visinha",new Pet());

        visits.add(visitDebora);
        visits.add(visitFabiola);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(visits);
        Set<Visit> visits = service.findAll();
        assertEquals(2,visits.size());
    }

    @Test
    void findById() {
        when(visitRepository.findById(visitDebora.getId())).thenReturn(Optional.of(visitDebora));
        Visit visit = service.findById(visitDebora.getId());
        assertEquals(visitDebora.getDescription(),visit.getDescription());

    }

    @Test
    void save() {
        when(service.save(visitFabiola)).thenReturn(visitFabiola);
        Visit visit = service.save(visitFabiola);
        assertEquals(visitFabiola.getDescription(), visit.getDescription());
    }

    @Test
    void delete() {
        service.delete(visitFabiola);
        verify(visitRepository).delete(visitFabiola);
    }

    @Test
    void deleteById() {
        service.deleteById(visitDebora.getId());
        verify(visitRepository).deleteById(visitDebora.getId());
    }
}