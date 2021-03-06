package com.alsinteligence.sfgpetclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

    public Speciality() {
    }

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality(Long id, String description) {
        super.setId(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
