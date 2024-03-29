package com.example.mefit.Services.Exercise;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

public interface ExerciseService extends CrudService<Exercise,Integer> {

    Workout getWorkout(int Id);
}
