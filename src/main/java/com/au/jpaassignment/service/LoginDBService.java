package com.au.jpaassignment.service;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginDBService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAllLogins(){
        return (List<Login>) loginRepository.findAll();
    }

    public Login getLoginById(int loginId){
        return loginRepository.findById(loginId).orElseThrow();
    }

    public Login createLogin(Login login){
        return loginRepository.save(login);
    }

    public String deleteLoginById(int loginId){
        loginRepository.deleteById(loginId);
        return "Login has been deleted";
    }

    public Login updateLogin(Login login){
        Login oldLogin;
        Optional<Login> optionalLogin = loginRepository.findById(login.getId());
        if (optionalLogin.isPresent()){
            oldLogin = optionalLogin.get();
            oldLogin.setActive(login.getActive());
            oldLogin.setId(login.getId());
            oldLogin.setUser(login.getUser());
            oldLogin.setPassword(login.getPassword());
            loginRepository.save(oldLogin);
        } else {
            return new Login();
        }
        return oldLogin;
    }
}
