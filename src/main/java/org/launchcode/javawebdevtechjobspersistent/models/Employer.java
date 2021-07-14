package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


    public Employer() { }

    @NotBlank
    @Size(max=50)
     private String location;

    public List<Job> getJobs() {
        return jobs;
    }


    public Employer(String location) {
        this.location = location;
    }
    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    @Valid
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

 }
