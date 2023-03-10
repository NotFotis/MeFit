package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private int id;
    @Column(name = "program_name",length = 50,nullable = false)
    private String name;
    @Column(name = "program_category",length = 50,nullable = false)
    private String category;
    @Column(name = "program_done")
    private Boolean done;

    @ManyToMany
    @JoinTable(
            name = "program_workout",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Workout> workout;

}