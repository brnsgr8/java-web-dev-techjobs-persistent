package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    public Skill() {}

    @NotBlank
    @Size(max=100)
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
                this.description = description;
    }
}