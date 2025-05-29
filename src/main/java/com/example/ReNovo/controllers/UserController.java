package com.example.ReNovo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReNovo.models.UserModel;
import com.example.ReNovo.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices service;

    // get all users 
    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers(){
        return service.getAllUsers();
    }

    // get user by id 
    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    // user Registration
    @PostMapping("/userRegister")
    public Object userRegistration(@RequestBody UserModel userData){
        return service.userRegistration(userData);
    }

    // update user details 
    @PutMapping("/updateUser/{id}")
    public Object updateUserDetails(@PathVariable Long id, @RequestBody UserModel updatedData){
        return service.updateUserDetails(id, updatedData);
    }

    // delete account
    @DeleteMapping("/deleteUser/{id}")
    public Object deleteUserAccount(@PathVariable Long id){
        return service.deleteUserAc(id);
    }


}
