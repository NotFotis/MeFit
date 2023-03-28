package com.example.mefit.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "profile_id")
    private int id;
    @OneToOne()
    @JoinColumn(name = "uid")
    private AppUser user;

    @Column(name = "profile_age")
    private int age;
    @Column(name = "profile_weight")
    private int weight;
    @Column(name = "profile_height")
    private int height;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="goal_id")
    private Goal goal;





}
