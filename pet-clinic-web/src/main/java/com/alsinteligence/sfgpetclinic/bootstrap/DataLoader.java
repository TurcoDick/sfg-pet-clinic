package com.alsinteligence.sfgpetclinic.bootstrap;

import com.alsinteligence.sfgpetclinic.model.*;
import com.alsinteligence.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtiesService specialtiesService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
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
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

        Owner ownerAlison = new Owner();
        ownerAlison.setFirstName("Alison ");
        ownerAlison.setLastName("Lucio");
        ownerAlison.setAddress("Rua Davos 193");
        ownerAlison.setCity("Campos do Jordão");
        ownerAlison.setTelephone("1236623384");
        ownerService.save(ownerAlison);

        System.out.println("Loaded Owner.....");

        Pet dogAlison = new Pet();
        dogAlison.setPetType(savedDogPetType);
        dogAlison.setOwner(ownerAlison);
        dogAlison.setBirthDate(LocalDate.now());
        dogAlison.setName("Dick");

        ownerAlison.getPets().add(dogAlison);

        Vet vet = new Vet();
        vet.setFirstName("Dr Francisco");
        vet.setLastName("Gente boa");
        vetService.save(vet);
        vet.getSpecialities().add(savedDentistry);

        System.out.println("Loaded Vet.....");

        Owner ownerfernanda = new Owner();
        ownerfernanda.setFirstName("Fernanda ");
        ownerfernanda.setLastName("Bueno");
        ownerfernanda.setAddress("Rua Davos 197");
        ownerfernanda.setCity("Campos do Jordão");
        ownerfernanda.setTelephone("1236623484");
        ownerService.save(ownerfernanda);

        Visit dogVisit = new Visit();
        dogVisit.setPet(dogAlison);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Dog sleeping");
        visitService.save(dogVisit);

        Pet ferPet = new Pet();
        ferPet.setPetType(savedCatPetType);
        ferPet.setOwner(ownerfernanda);
        ferPet.setBirthDate(LocalDate.now());
        ferPet.setName("Bichano");

        ownerfernanda.getPets().add(ferPet);

        System.out.println("Loaded Owner.....");

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr Maria");
        vet2.setLastName("Ana");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vet.....");


    }
}
