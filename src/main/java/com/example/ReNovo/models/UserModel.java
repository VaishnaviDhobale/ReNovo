package com.example.ReNovo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserData")
public class UserModel {
    @Id
    @GeneratedValue
    private long id;
}
