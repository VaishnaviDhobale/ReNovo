package com.example.ReNovo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserLogins")



public class UserLoginModel {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;


}
