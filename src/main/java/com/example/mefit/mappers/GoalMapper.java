package com.example.mefit.mappers;

import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.dtos.goal.GoalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GoalMapper {
    @Mapping(target = "profiles", qualifiedByName = "profilesToProfilesId")
    GoalDTO goalToGoalDTO(Goal goal);

    Collection<GoalDTO> goalToGoalDTO(Collection<Goal> goal);

    @Named(value = "profilesToProfilesId")
    default Set<Integer> map(Set<Profile> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}