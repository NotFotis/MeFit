package com.example.mefit.Services.Workout;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

import java.util.Set;

public interface WorkoutService extends CrudService<Workout,Integer> {
    Set<Goal> getGoal(int Id);
    Set<Program> getProgram(int Id);
}
