package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.data.JobPRepository;
import org.launchcode.javawebdevtechjobspersistent.data.SkillRepository;
import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {


    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobPRepository jobPRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "myJobs");
        model.addAttribute("jobs", jobPRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute( new Job());
        return "add";
    }


    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

    if (errors.hasErrors()) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }
     Employer employer = employerRepository.findById(employerId).orElse(new Employer());
    newJob.setEmployer(employer);

    List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
    newJob.setSkills(skillObjs);
    jobPRepository.save(newJob);
        return "redirect:";

}
    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional optJob = jobPRepository.findById(jobId);
        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
//            model.addAttribute("title", "Job: " + ((Skill) optSkill.get()).getId());
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:/";
        }
    }
}

