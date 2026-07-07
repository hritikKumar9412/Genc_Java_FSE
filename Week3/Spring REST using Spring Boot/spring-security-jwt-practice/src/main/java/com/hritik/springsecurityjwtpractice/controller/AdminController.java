package com.hritik.springsecurityjwtpractice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {

        return "Welcome Admin! This endpoint can only be accessed by ADMIN users.";

    }

}