package com.au.jpaassignment.controller;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.model.User;
import com.au.jpaassignment.service.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDBService userDBService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDBService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        return userDBService.getUserById(userId);
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return userDBService.createUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        return userDBService.deleteUser(userId);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userDBService.updateUser(user);
    }

    @GetMapping("/query/users")
    public List<User> getUsersQuery(){
        return userDBService.getUsersQuery();
    }

    @PostMapping("/query/createUser")
    public User createUserQuery(@RequestBody User user){
        return userDBService.createUserQuery(user);
    }

    @DeleteMapping("/query/users/{userId}")
    public String deleteUserQuery(@PathVariable int userId){
        return userDBService.deleteUserQuery(userId);
    }
}
