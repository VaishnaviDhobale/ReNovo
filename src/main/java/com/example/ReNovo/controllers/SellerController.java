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

import com.example.ReNovo.models.SellerLoginModel;
import com.example.ReNovo.models.SellerModel;
import com.example.ReNovo.services.SellerServices;

@RestController
@RequestMapping("/seller")


public class SellerController {
    @Autowired
    SellerServices service;

    // get all seller 
    @GetMapping("/getAllSellers")
    public List<SellerModel> getAllSellers(){
        return service.getAllSellers();
    }

    // get seller by id 
    @GetMapping("/getSellerById/{id}")
    public Object getSellerById(@PathVariable Long id){
        return service.getSellerById(id);
    }

    // seller Registration
    @PostMapping("/sellerRegister")
    public Object sellerRegistration(@RequestBody SellerModel sellerData){
        return service.sellerRegistration(sellerData);
    }

    // seller login
    @PostMapping("/sellerLogin")
    public String sellerLogin(@RequestBody SellerLoginModel loginData){
        return service.sellerLogin(loginData);
    }

    // update seller details 
    @PutMapping("/updateSeller/{id}")
    public Object updateSellerDetails(@PathVariable Long id, @RequestBody SellerModel updatedData){
        return service.updateSellerDetails(id, updatedData);
    }

    // delete account
    @DeleteMapping("/deleteSeller/{id}")
    public Object deleteSellerAccount(@PathVariable Long id){
        return service.deleteSellerAc(id);
    }
}
