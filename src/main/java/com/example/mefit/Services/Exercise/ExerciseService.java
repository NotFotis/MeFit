package com.example.mefit.Services.Exercise;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

public interface ExerciseService extends CrudService<Exercise,Integer> {
    Exercise findById(int id);

    Exercise update(int id, Exercise entity);

    void deleteById(int id);

    boolean exists(int id);

    Workout getWorkout(int Id);
}
