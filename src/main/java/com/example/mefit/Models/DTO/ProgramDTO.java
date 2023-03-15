package com.example.mefit.Models.DTO;

import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class ProgramDTO {
    private int id;
    private String name;
    private String category;
    private Boolean done;
    private Set<Integer> workout;
    private Set<Integer> goal;
}
