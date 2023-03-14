package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profile_id;
    @Column()
    private int age;
    @Column()
    private int weight;
    @Column()
    private int height;
    @ManyToOne
    @JoinColumn(name="goal_id",nullable = false)
    private Goal goal;

    //THE USER_ID
}
