package com.example.mefit.Services.Program;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

import java.util.Set;

public interface ProgramService extends CrudService<Program,Integer> {
    Set<Workout> getWorkout(int Id);
    Set<Goal> getGoal(int Id);
}
