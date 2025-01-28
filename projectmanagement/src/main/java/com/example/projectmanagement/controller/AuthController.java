package com.example.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returns the login.html template
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home"; // Redirect to home if credentials match
        }
        return "login"; // Redirect back to login on failure
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // Redirect to login after logout
    }
}
