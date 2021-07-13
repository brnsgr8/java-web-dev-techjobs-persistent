package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    public Skill() {}

    @NotBlank
    @Size(max=500)
    private String description;

    public Skill(@NotBlank @Size(max = 500) String description) {
        this.description = description;
    }

    public String getSkillDescription() {
        return description;
    }

    public void setSkillDescription(String description) {
        this.description = description;
    }
}