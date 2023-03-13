package com.example.mefit.Models.DTO;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Program;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class WorkoutDTO {
    private int id;
    private String name;
    private String type;
    private Boolean complete_workout;
    private Set<Integer> program;
    Set<Integer>  exercise;
}
