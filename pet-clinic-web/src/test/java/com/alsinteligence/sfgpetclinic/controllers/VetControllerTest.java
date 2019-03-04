package com.alsinteligence.sfgpetclinic.controllers;

import com.alsinteligence.sfgpetclinic.model.Speciality;
import com.alsinteligence.sfgpetclinic.model.Vet;
import com.alsinteligence.sfgpetclinic.services.VetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @InjectMocks
    VetController controller;

    @Mock
    VetService service;

    MockMvc mockMvc;

    Set<Vet> vetSet = new HashSet<>();

    Vet vet1 = new Vet(new HashSet<Speciality>());
    Vet vet2 = new Vet(new HashSet<Speciality>());

    @BeforeEach
    void setUp() {

        vetSet.add(vet1);
        vetSet.add(vet2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listVets() throws Exception {
        when(service.findAll()).thenReturn(vetSet);
        mockMvc.perform(get("/vets"))
        .andExpect(view().name("vets/index"))
        .andExpect(model().attribute("vets",hasSize(2)));
    }
}