package com.br.erijhonson.springsecurityjwt.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getEmployees() {
        return "Welcome!";
    }
}
