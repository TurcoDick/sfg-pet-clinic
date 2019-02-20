package com.alsinteligence.sfgpetclinic.services;

import com.alsinteligence.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
