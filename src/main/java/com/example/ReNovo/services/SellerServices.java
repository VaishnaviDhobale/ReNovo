package com.example.ReNovo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReNovo.models.SellerLoginModel;
import com.example.ReNovo.models.SellerModel;
import com.example.ReNovo.repository.SellerRepository;

@Service
public class SellerServices {
    @Autowired
    SellerRepository repo;

    // seller registration
    public Object sellerRegistration(SellerModel sellerData) {
        try {
            Optional<SellerModel> existingSeller = repo.findByEmail(sellerData.getEmail());

            if (existingSeller.isPresent()) {
                return "You already have an account. Please log in.";
            }

            repo.save(sellerData);
            return "Seller registered successfully.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // seller login
    public String sellerLogin(SellerLoginModel loginData) {

        Optional<SellerModel> sellerOpt = repo.findByEmail(loginData.getEmail());
        if (sellerOpt.isEmpty()) {
            return "Seller not found, please register.";
        }
        SellerModel user = sellerOpt.get();

        if (user.getPassword().equals(loginData.getPassword())) {
            return "Login successful!";
        } else {
            return "Incorrect password, please try again.";
        }
    }

    // get all sellers
    public List<SellerModel> getAllSellers() {
        return repo.findAll();
    }

    // get seller by id
    public Object getSellerById(Long id) {
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

    // update seller data
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
