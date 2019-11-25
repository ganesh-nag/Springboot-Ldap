package com.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/users")
    public String index() {
        return "Welcome to the Users page!";
    }
	
	@RequestMapping("/home")
    public String profiles() {
        return "Welcome to the Home page!";
    }

}
