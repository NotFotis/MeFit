package com.example.mefit.services.exercise;

import com.example.mefit.models.Exercise;
import com.example.mefit.models.Workout;
import com.example.mefit.services.CrudService;

public interface ExerciseService extends CrudService<Exercise,Integer> {
    Workout getWorkout(int Id);
}
