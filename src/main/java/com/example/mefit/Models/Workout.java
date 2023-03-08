package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private int id;
    @Column(name = "workout_name",length = 50,nullable = false)
    private String name;
    @Column(name = "workout_type",length = 50,nullable = false)
    private String type;
    @Column(name = "workout_complete")
    private Boolean complete_workout;

    @ManyToMany
    @JoinTable(
            name = "goal_workout",
            joinColumns = @JoinColumn(name = "goal_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Goal> goal;

    @ManyToMany
    @JoinTable(
            name = "program_workout",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Program> program;


}
