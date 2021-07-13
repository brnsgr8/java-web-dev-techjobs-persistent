package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


    public Employer() { }

    @NotBlank
    @Size(max=50)
     private String location;

    @Valid
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

 }
