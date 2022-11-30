package com.au.jpaassignment.controller;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.service.LoginDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginDBService loginDBService;

    @GetMapping("/logins")
    public List<Login> getAllLogins(){
        return loginDBService.getAllLogins();
    }

    @GetMapping("/logins/{loginId}")
    public Login getLoginById(@PathVariable int loginId){
        return loginDBService.getLoginById(loginId);
    }

    @PostMapping("/createLogin")
    public Login createLogin(@RequestBody Login login){
        return loginDBService.createLogin(login);
    }

    @DeleteMapping("/logins/{userId}")
    public String deleteLogin(@PathVariable int loginId){
        return loginDBService.deleteLoginById(loginId);
    }

    @PutMapping("/updateLogin")
    public Login updateLogin(Login login){
        return loginDBService.updateLogin(login);
    }
}
