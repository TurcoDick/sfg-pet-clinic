package com.alsinteligence.sfgpetclinic.controllers;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Pet;
import com.alsinteligence.sfgpetclinic.services.OwnerService;
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
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService service;

    @InjectMocks
    OwnerController controller;

    Set<Owner> ownerSet;

    MockMvc mockMvc;

    Owner ownerFernanda;

    Owner ownerPaula;

    @BeforeEach
    void setUp() {

        ownerFernanda = new Owner(1L,"Fernanda","Dantas","Rua Venesa",
                "Campinas","345555555",new HashSet<Pet>());

        ownerPaula = new Owner(2L,"Paula","Dantas","Rua Venesa",
                "Campinas", "345555555",new HashSet<Pet>());

        ownerSet = new HashSet<>();
        ownerSet.add(ownerPaula);
        ownerSet.add(ownerFernanda);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception{
        when(service.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception{
        when(service.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndexHtml() throws Exception{
        when(service.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners/owners.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(service);
    }
}