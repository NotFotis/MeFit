package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private boolean complete;

    @JsonIgnore
    @ManyToMany(mappedBy = "workout")
    private Set<Program> program;
    @JsonIgnore
    @OneToMany(mappedBy = "workout")
    private Set<Exercise> exercise;

}
