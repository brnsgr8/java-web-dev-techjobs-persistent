package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank
    @Size(min= 2, max = 100)
    private String description;

    @ManyToMany (mappedBy= "skills" )
    private List<Job> jobs = new ArrayList<>();

    public Skill() {
    }
    public Skill (String description){
        this.description = description;
    }

    public String getDescription() { return description;  }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void addJob (Job job){
        this.jobs.add(job);
    }
}