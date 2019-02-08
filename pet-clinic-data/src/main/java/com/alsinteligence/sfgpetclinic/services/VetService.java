package com.alsinteligence.sfgpetclinic.services;

import com.alsinteligence.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
