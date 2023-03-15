package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Exercise.ExerciseService;
import com.example.mefit.Services.Program.ProgramService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public abstract class WorkoutMapper {
@Autowired
    protected ExerciseService exerciseService;
@Autowired
    protected ProgramService programService;

    @Mapping(target = "exercise", source = "exercise", qualifiedByName ="exerciseToExerciseID" )
    @Mapping(target = "program", source = "program", qualifiedByName = "programToProgramID")
    public abstract WorkoutDTO workoutToWorkoutDTO(Workout workout);
    public abstract Collection<WorkoutDTO> workoutToWorkoutDTO(Collection<Workout> workout);
    @Named(value = "programToProgramID")
    Set<Integer> mapProgram(Set<Program> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named(value = "exerciseToExerciseID")
    Set<Integer> mapExercise(Set<Exercise> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named("exerciseIdToExercise")
    Set<Exercise> mapIdsToExercise(Set<Integer> id) {
        return id.stream()
                .map( i-> exerciseService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("programIdsToProgram")
    Set<Program> mapIdsToProgram(Set<Integer> id) {
        return id.stream()
                .map( i-> programService.findById(i))
                .collect(Collectors.toSet());
    }
    @Mapping(target = "exercise", source = "exercise", qualifiedByName = "exerciseIdToExercise")
    @Mapping(target = "program", source = "program", qualifiedByName = "programIdsToProgram")
    public abstract Workout workoutDtoToWorkout(WorkoutDTO workoutDTO);



}
