package com.example.mefit.mappers;

import com.example.mefit.models.Workout;
import com.example.mefit.models.Exercise;
import com.example.mefit.models.dtos.workout.WorkoutDTO;
import com.example.mefit.services.exercise.ExerciseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class WorkoutMapper {

    ExerciseService exerciseService;

    @Mapping(target = "exercises", qualifiedByName = "exerciseToExerciseId")
    public abstract WorkoutDTO workoutToWorkoutDTO(Workout workout);

    public abstract Collection<WorkoutDTO> workoutToWorkoutDTO(Collection<Workout> workout);

    @Named(value = "exerciseToExerciseId")
    Set<Integer> map(Set<Exercise> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getExercise_id())
                .collect(Collectors.toSet());
    }

    @Named("exerciseIdsToExercise")
    Set<Exercise> mapIdsToExercise(Set<Integer> id) {
        return id.stream()
                .map( i-> exerciseService.findById(i))
                .collect(Collectors.toSet());
    }

    @Mapping(target = "exercises", source = "exercises", qualifiedByName = "exerciseIdsToExercise")
    public abstract Workout workoutDTOToWorkout(WorkoutDTO workoutDTO);

}