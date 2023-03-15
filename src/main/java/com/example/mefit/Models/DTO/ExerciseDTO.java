package com.example.mefit.Models.DTO;

import com.example.mefit.Models.Workout;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTO {
    private int id;
    private String name;
    private String desc;
    private String tmg;
    private int repetitions;
    private String img;
    private String vid;
    private Boolean complete;
    private int workout;
}
