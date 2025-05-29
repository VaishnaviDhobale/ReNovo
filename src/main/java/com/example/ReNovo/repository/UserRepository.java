package com.example.ReNovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReNovo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
