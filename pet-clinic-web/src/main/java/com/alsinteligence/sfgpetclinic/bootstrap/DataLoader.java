package com.alsinteligence.sfgpetclinic.bootstrap;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Vet;
import com.alsinteligence.sfgpetclinic.services.OwnerService;
import com.alsinteligence.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        forDataLoad();

    }

    public void forDataLoad(){

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Alison ");
        owner.setLasName("Lucio");
        ownerService.save(owner);

        System.out.println("Loaded Owner.....");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Dick");
        vet.setLasName("Dogão");
        vetService.save(vet);

        System.out.println("Loaded Vet.....");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fernanda ");
        owner2.setLasName("Bueno");
        ownerService.save(owner2);

        System.out.println("Loaded Owner.....");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jadi");
        vet2.setLasName("Pit");
        vetService.save(vet2);

        System.out.println("Loaded Vet.....");


    }
}
