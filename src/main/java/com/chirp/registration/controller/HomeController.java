package com.chirp.registration.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index()
    {
        String json = "{\"name\":\"index.html\"}";
        return json;//"index.html";
    }

    @PostMapping("/")
    public String logIn()
    {
        return "student_dashboard.html";
    }
}
