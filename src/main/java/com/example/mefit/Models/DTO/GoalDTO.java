package com.example.mefit.Models.DTO;

import com.example.mefit.Models.Program;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class GoalDTO {
    private int id;
    private String name;
    private Date start_date;
    private Date end_date;
    private int total_programs;
    private int completed_programs;
    private Boolean complete;
    private Set<Integer> program;
    private Set<Integer>  profile;

}
