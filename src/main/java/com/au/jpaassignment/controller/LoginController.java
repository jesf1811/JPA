package com.au.jpaassignment.controller;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.model.User;
import com.au.jpaassignment.service.LoginDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginDBService loginDBService;

    @GetMapping("/logins")
    public ResponseEntity<List<Login>> getAllLogins(){
        return new ResponseEntity<>(loginDBService.getAllLogins(),HttpStatus.OK);
    }

    @GetMapping("/logins/{loginId}")
    public ResponseEntity<Login> getLoginById(@PathVariable int loginId){
        return new ResponseEntity<>(loginDBService.getLoginById(loginId),HttpStatus.OK);
    }

    @PostMapping("/logins")
    public Login createLogin(@RequestBody Login login){
        return loginDBService.createLogin(login);
    }

    @DeleteMapping("/logins/{userId}")
    public String deleteLogin(@PathVariable int loginId){
        return loginDBService.deleteLoginById(loginId);
    }

    @PutMapping("/logins")
    public Login updateLogin(@RequestBody Login login){
        return loginDBService.updateLogin(login);
    }

//    @GetMapping("/query/logins")
//    public List<Login> getLoginsQuery(){
//        return loginDBService.getLoginsQuery();
//    }
//
//    @PostMapping("/query/createLogin")
//    public Login createLoginQuery(@RequestBody Login login){
//        return loginDBService.createLoginQuery(login);
//    }
//
//    @DeleteMapping("/query/logins/{loginId}")
//    public String deleteLoginQuery(@PathVariable int loginId){
//        return loginDBService.deleteLoginQuery(loginId);
//    }
}
