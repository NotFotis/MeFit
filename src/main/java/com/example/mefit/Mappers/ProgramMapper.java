package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.ProgramDTO;
import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Exercise.ExerciseService;
import com.example.mefit.Services.Goal.GoalService;
import com.example.mefit.Services.Program.ProgramService;
import com.example.mefit.Services.Workout.WorkoutService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class ProgramMapper {
    @Autowired
    protected WorkoutService workoutService;
    @Autowired
    protected GoalService goalService;

    @Mapping(target = "workout", source = "workout", qualifiedByName ="workoutToWorkoutID" )
    @Mapping(target = "goal", source = "goal", qualifiedByName = "goalToGoalID")
    public abstract ProgramDTO programToProgramDTO(Program program);
    public abstract Collection<ProgramDTO> programToProgramDTO(Collection<Program> program);
    @Named(value = "workoutToWorkoutID")
    Set<Integer> mapWorkout(Set<Workout> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named(value = "goalToGoalID")
    Set<Integer> mapGoal(Set<Goal> value1) {
        if (value1 == null)
            return null;
        return value1.stream()
                .map(d-> d.getId())
                .collect(Collectors.toSet());
    }
    @Named("workoutIdToWorkout")
    Set<Workout> mapIdsToWokrout(Set<Integer> id) {
        return id.stream()
                .map( i-> workoutService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("goalIdsToGoal")
    Set<Goal> mapIdsToGoal(Set<Integer> id1) {
        return id1.stream()
                .map( j-> goalService.findById(j))
                .collect(Collectors.toSet());
    }

    @Mapping(target = "workout", source = "workout", qualifiedByName = "workoutIdToWorkout")
    @Mapping(target = "goal", source = "goal", qualifiedByName = "goalIdsToGoal")
    public abstract Program programDtoToProgram(ProgramDTO programDTO);
}
