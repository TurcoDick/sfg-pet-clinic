package com.alsinteligence.sfgpetclinic.bootstrap;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.PetType;
import com.alsinteligence.sfgpetclinic.model.Vet;
import com.alsinteligence.sfgpetclinic.services.OwnerService;
import com.alsinteligence.sfgpetclinic.services.PetTypeService;
import com.alsinteligence.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        forDataLoad();

    }

    public void forDataLoad(){

        Owner owner = new Owner();
        owner.setFirstName("Alison ");
        owner.setLasName("Lucio");
        ownerService.save(owner);

        System.out.println("Loaded Owner.....");

        Vet vet = new Vet();
        vet.setFirstName("Dick");
        vet.setLasName("Dogão");
        vetService.save(vet);

        System.out.println("Loaded Vet.....");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fernanda ");
        owner2.setLasName("Bueno");
        ownerService.save(owner2);

        System.out.println("Loaded Owner.....");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jadi");
        vet2.setLasName("Pit");
        vetService.save(vet2);

        System.out.println("Loaded Vet.....");


    }
}
