package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;
    @Column(name="goal_name",length = 50,nullable = false)
    private String name;
    @Column(name = "goal_end_date", length = 50,nullable = false)
    private String end_date;
    @Column(name = "goal_achieved")
    private Boolean achieved;

    @ManyToOne
    @JoinColumn(name="program_id")
    private Program program;

    @ManyToMany
    @JoinTable(
            name = "goal_workout",
            joinColumns = @JoinColumn(name = "goal_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Workout> workout;

}