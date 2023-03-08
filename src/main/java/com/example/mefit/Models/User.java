package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_username",length=50,nullable = false)
    private String username;
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    @Column(name="user_email",length = 50,nullable = false)
    private String email;
    @Column(name = "user_firstname",length = 50,nullable = false)
    private String firstname;
    @Column(name = "user_lastname",length = 50, nullable = false)
    private String lastname;
    @Column(name = "user_isContributor")
    private Boolean isContributor;
    @Column(name = "user_isAdmin")
    private Boolean isAdmin;
}
