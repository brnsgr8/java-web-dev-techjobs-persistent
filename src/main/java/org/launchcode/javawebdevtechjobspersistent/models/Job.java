package org.launchcode.javawebdevtechjobspersistent.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
//@Table(name="job")
public class Job extends AbstractEntity{

//    private int id;

//    private String name;
@ManyToOne
//@JoinColumn
@NotNull
    private Employer employer;

@ManyToMany
@NotNull
    private List<Skill> skills = new ArrayList<>();

    public Job() {}

    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters.

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
