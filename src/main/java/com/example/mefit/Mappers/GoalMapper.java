package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.GoalDTO;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Services.Program.ProgramService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
@Component
@Mapper(componentModel = "spring")
public abstract class GoalMapper {
    @Autowired
    protected ProgramService programService;
    @Mapping(target = "program", source = "program", qualifiedByName = "programToProgramID")
    public abstract GoalDTO goalToGoalDTO(Goal goal);
    public abstract Collection<GoalDTO> goalToGoalDTO(Collection<Goal> goal);
    @Named(value = "programToProgramID")
    Set<Integer> map(Set<Program> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named("programIdsToProgram")
    Set<Program> mapIdsToCharacter(Set<Integer> id) {
        return id.stream()
                .map( i-> programService.findById(i))
                .collect(Collectors.toSet());
    }
    @Mapping(target = "program", source = "program", qualifiedByName = "programIdsToProgram")
    public abstract Goal goalDtoToGoal(GoalDTO goalDTO);



}
