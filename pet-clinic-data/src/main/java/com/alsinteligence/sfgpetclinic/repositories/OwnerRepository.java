package com.alsinteligence.sfgpetclinic.repositories;

import com.alsinteligence.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
