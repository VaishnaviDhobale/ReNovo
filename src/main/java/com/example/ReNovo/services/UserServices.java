package com.example.ReNovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReNovo.models.UserModel;
import com.example.ReNovo.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    UserRepository repo;

    // user registration
    public Object userRegistration(UserModel userData) {
        try {
            repo.save(userData);
            return "User register successfully.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // get all user 
     public List<UserModel>getAllUsers() {
           return repo.findAll();
    }

    // get user by id 
    public Object getUserById(Long id){
        try {
            if (repo.existsById(id)) {
                return repo.findById(id);
            } else {
                return "User with ID " + id + " does not found.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Update user data
    public Object updateUserDetails(Long id, UserModel updatedData) {
        try {
            UserModel userData = repo.findById(id).orElseThrow();

            // update values one by one
            userData.setName(updatedData.getName());
            userData.setEmail(updatedData.getEmail());
            userData.setUsername(updatedData.getUsername());
            userData.setPassword(updatedData.getPassword());

            repo.save(userData);
            return "User with id " + id + " updated.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // delete user details 
    public Object deleteUserAc(Long id) {
        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return "User account with ID " + id + " deleted.";
            } else {
                return "User account with ID " + id + " does not found.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
