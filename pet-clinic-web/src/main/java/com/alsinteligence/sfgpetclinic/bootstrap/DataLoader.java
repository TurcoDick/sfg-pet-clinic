package com.alsinteligence.sfgpetclinic.bootstrap;

import com.alsinteligence.sfgpetclinic.model.Owner;
import com.alsinteligence.sfgpetclinic.model.Vet;
import com.alsinteligence.sfgpetclinic.services.OwnerService;
import com.alsinteligence.sfgpetclinic.services.VetService;
import com.alsinteligence.sfgpetclinic.services.map.OwnerServiceMap;
import com.alsinteligence.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        forDataLoad(5);

    }

    public void forDataLoad(int count){
        int i;
        for(i = 0; i < count; i++){
            Owner owner = new Owner();
            owner.setId(1L);
            owner.setFisrtName("Alison "+ "indice "+i);
            owner.setLasName("Lucio" + "indice " + i);
            ownerService.save(owner);

            System.out.println("Loaded Owner.....");

            Vet vet = new Vet();
            vet.setId(1L);
            vet.setFisrtName("vetAlison "+i);
            vet.setLasName("vetLucio" +i);

            System.out.println("Loaded Vet.....");

        }
    }
}
