package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int program_id;
    @Column(length = 30, nullable = false)
    private String program_name;
    @Column(length = 30)
    private String category;
    @Column(nullable = false)
    private boolean complete_program;

    @ManyToMany
    @JoinTable(
            name = "program_workout",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Workout> workouts;

    @ManyToMany
    @JoinTable(
            name = "program_goal",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "goal_id")
    )
    private Set<Goal> goals;
}
