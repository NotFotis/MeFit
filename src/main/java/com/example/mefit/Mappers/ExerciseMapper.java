package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.ExerciseDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Workout.WorkoutService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {
    @Autowired
    protected WorkoutService workoutService;

    @Mapping(target = "workout", source = "workout.id")
    public abstract ExerciseDTO exerciseToExerciseDTO(Exercise exercise);
    public abstract Collection<ExerciseDTO> exerciseToExerciseDTO(Collection<Exercise> exercise);

    @Named("workoutIdToWorkout")
    Workout mapIdToWorkout(int id) {
        return workoutService.findById(id);
    }
    @Mapping(target = "workout", source = "workout", qualifiedByName="workoutIdToWorkout")
    public abstract Exercise exerciseDtoToExercise(ExerciseDTO exerciseDTO);

}
