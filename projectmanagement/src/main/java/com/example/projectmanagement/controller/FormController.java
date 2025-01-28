package com.example.projectmanagement.controller;

import com.example.projectmanagement.entity.Employee;

import com.example.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
public class FormController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "form"; // Returns the form.html template
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/form"; // Redirects to the form page
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/form"; // Redirects to the form page
    }
    @GetMapping("/exportToExcel")
    public String exportToExcel() {
        try {
            employeeService.exportToExcel();
        } catch (IOException e) {
            e.printStackTrace();
            // You can add error handling here
        }
        return "redirect:/form"; // Redirects back to the form page
    }
}
