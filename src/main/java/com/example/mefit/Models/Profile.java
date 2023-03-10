package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;
    @Column(name = "profile_age")
    private int age;
    @Column(name = "profile_weight")
    private int weight;
    @Column(name = "profile_height")
    private int height;
    @Column(name = "profile_medicalCondition")
    private String medical_condition;
    @Column(name = "profile_disabilities")
    private String disabilities;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="goal_id")
    private Goal goal;



}