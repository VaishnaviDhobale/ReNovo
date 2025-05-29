package com.example.ReNovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReNovo.models.SellerModel;
import com.example.ReNovo.repository.SellerRepository;


@Service
public class SellerServices {
    @Autowired
    SellerRepository repo;

    // Seller registration
    public Object sellerRegistration(SellerModel sellerData) {
        try {
            repo.save(sellerData);
            return "Seller register successfully.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // get all sellers 
     public List<SellerModel>getAllSellers() {
           return repo.findAll();
    }

    // get Seller by id 
    public Object getSellerById(Long id){
        try {
            if (repo.existsById(id)) {
                return repo.findById(id);
            } else {
                return "Seller with ID " + id + " does not found.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Update seller data
    public Object updateSellerDetails(Long id, SellerModel updatedData) {
        try {
            SellerModel sellerData = repo.findById(id).orElseThrow();

            // update values one by one
            sellerData.setName(updatedData.getName());
            sellerData.setEmail(updatedData.getEmail());
            sellerData.setPassword(updatedData.getPassword());
            sellerData.setAddress(updatedData.getAddress());
            sellerData.setContact(updatedData.getContact());

            repo.save(sellerData);
            return "Seller with id " + id + " updated.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // delete seller details 
    public Object deleteSellerAc(Long id) {
        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return "Seller account with ID " + id + " deleted.";
            } else {
                return "Seller account with ID " + id + " does not found.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
