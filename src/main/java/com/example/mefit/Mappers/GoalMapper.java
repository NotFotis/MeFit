package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.GoalDTO;
import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Profile.ProfileService;
import com.example.mefit.Services.Program.ProgramService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class GoalMapper {
    @Autowired
    protected ProgramService programService;
    @Autowired
    protected ProfileService profileService;

    @Mapping(target = "profile", source = "profile", qualifiedByName = "profileToProfileID")
    @Mapping(target = "program", source = "program", qualifiedByName = "programToProgramID")
    public abstract GoalDTO goalToGoalDTO(Goal goal);
    public abstract Collection<GoalDTO> goalToGoalDTO(Collection<Goal> goal);
    @Named(value = "programToProgramID")
    Set<Integer> mapProgram(Set<Program> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named(value = "profileToProfileID")
    Set<Integer> mapProfile(Set<Profile> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named("programIdsToProgram")
    Set<Program> mapIdsToProgram(Set<Integer> id) {
        return id.stream()
                .map( i-> programService.findById(i))
                .collect(Collectors.toSet());
    }
    @Named("profileIdsToProfile")
    Set<Profile> mapIdsToProfile(Set<Integer> id) {
        return id.stream()
                .map( i-> profileService.findById(i))
                .collect(Collectors.toSet());
    }
    @Mapping(target = "profile", source = "profile", qualifiedByName = "profileIdsToProfile")
    @Mapping(target = "program", source = "program", qualifiedByName = "programIdsToProgram")
    public abstract Goal goalDtoToGoal(GoalDTO goalDTO);
}
