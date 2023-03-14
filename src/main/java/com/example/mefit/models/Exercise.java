package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exercise_id;
    @Column(length = 30,nullable = false)
    private String exercise_name;
    @Column(length = 400)
    private String description;
    @Column(length = 30)
    private String target_muscle_group;
    @Column()
    private int repetitions;
    @Column(length = 200)
    private String image;
    @Column(length = 200)
    private String video;
    @Column(nullable = false)
    private Boolean complete;
    @ManyToOne
    @JoinColumn(name="workout_id",nullable = false)
    private Workout workout;
}
