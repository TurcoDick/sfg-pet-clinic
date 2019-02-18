package com.alsinteligence.sfgpetclinic.bootstrap;

import com.alsinteligence.sfgpetclinic.model.*;
import com.alsinteligence.sfgpetclinic.services.OwnerService;
import com.alsinteligence.sfgpetclinic.services.PetTypeService;
import com.alsinteligence.sfgpetclinic.services.SpecialtiesService;
import com.alsinteligence.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }


    }

    private void loadData(){

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtiesService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtiesService.save(radiology);

        Owner owner = new Owner();
        owner.setFirstName("Alison ");
        owner.setLastName("Lucio");
        owner.setAddress("Rua Davos 193");
        owner.setCity("Campos do Jordão");
        owner.setTelephone("1236623384");
        ownerService.save(owner);

        System.out.println("Loaded Owner.....");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Dick");

        owner.getPets().add(mikesPet);

        Vet vet = new Vet();
        vet.setFirstName("Dick");
        vet.setLastName("Dogão");
        vetService.save(vet);
        vet.getSpecialities().add(savedDentistry);

        System.out.println("Loaded Vet.....");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fernanda ");
        owner2.setLastName("Bueno");
        owner2.setAddress("Rua Davos 197");
        owner2.setCity("Campos do Jordão");
        owner2.setTelephone("1236623484");
        ownerService.save(owner2);

        Pet ferPet = new Pet();
        ferPet.setPetType(savedCatPetType);
        ferPet.setOwner(owner2);
        ferPet.setBirthDate(LocalDate.now());
        ferPet.setName("Bichano");

        owner2.getPets().add(ferPet);

        System.out.println("Loaded Owner.....");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jadi");
        vet2.setLastName("Pit");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);

        System.out.println("Loaded Vet.....");


    }
}
