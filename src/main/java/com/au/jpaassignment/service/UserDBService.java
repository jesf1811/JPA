package com.au.jpaassignment.service;

import com.au.jpaassignment.model.User;
import com.au.jpaassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDBService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(int userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(int userId){
        userRepository.deleteById(userId);
        return "User successfully deleted";
    }

    public User updateUser(User user){
        User oldUser;
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()){
            oldUser = optionalUser.get();
            oldUser.setAddress(user.getAddress());
            oldUser.setId(user.getId());
            oldUser.setContactNo(user.getContactNo());
            oldUser.setName(user.getName());
            oldUser.setLogin(user.getLogin());
            oldUser.setType(user.getType());
            userRepository.save(oldUser);
        } else {
            return new User();
        }
        return oldUser;
    }

//    public List<User> getUsersQuery(){
//        return userRepository.findAllUsers();
//    }
//
//    public User createUserQuery(User user){
//        return userRepository.createUser(user.getId(),user.getAddress(),user.getContactNo(),user.getName(),user.getType(),user.getLogin());
//    }
//
//    public String deleteUserQuery(int userId){
//        userRepository.deleteUser(userId);
//        return "User successfully deleted";
//    }
}
