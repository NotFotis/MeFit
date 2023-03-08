package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;
    @Column(name = "exercise_name",length = 50,nullable = false)
    private String name;
    @Column(name = "exercise_desc",length = 200)
    private String desc;
    @Column(name = "exercise_tmg",length = 50)
    private String tmg;//tmg stands for target muscle group
    @Column(name = "exerciise_repetitions")
    private int repetitions;
    @Column(name = "exercise_img",length = 200)
    private String img;
    @Column(name = "exercise_vid",length = 200)
    private String vid;
    @Column(name = "exercise_complete")
    private Boolean complete;

}
