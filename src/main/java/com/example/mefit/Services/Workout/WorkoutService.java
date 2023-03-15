package com.example.mefit.Services.Workout;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

import java.util.Set;

public interface WorkoutService extends CrudService<Workout,Integer> {
    Workout findById(int id);

    Workout update(int id, Workout entity);

    void deleteById(int id);

    boolean exists(int id);

    Set<Exercise> getExercise(int Id);

    Set<Program> getProgram(int Id);
}
