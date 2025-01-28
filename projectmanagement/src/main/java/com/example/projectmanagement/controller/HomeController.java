// HomeController.java
package com.example.projectmanagement.controller;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "home";
    }

    @PostMapping("/home/addProject")
    public String addProject(@ModelAttribute Project project) {
        projectService.saveProject(project);
        return "redirect:/home";
    }

    @GetMapping("/home/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/home";
    }
    
    @GetMapping("/documents")
    public String documentsPage() {
        return "documents"; // returns the documents.html page
    }


}
