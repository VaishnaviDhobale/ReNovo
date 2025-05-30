package com.example.ReNovo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReNovo.models.SellerModel;

public interface SellerRepository extends JpaRepository<SellerModel, Long>{
    Optional<SellerModel> findByEmail(String email);
}
