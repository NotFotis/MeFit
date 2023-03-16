package com.example.mefit.mappers;

import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.dtos.goal.GoalDTO;
import com.example.mefit.services.profile.ProfileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class GoalMapper {

    ProfileService profileService;

    @Mapping(target = "profiles", qualifiedByName = "profileToProfileId")
    public abstract GoalDTO goalToGoalDTO(Goal goal);

    public abstract Collection<GoalDTO> goalToGoalDTO(Collection<Goal> goal);

    @Named(value = "profileToProfileId")
    Set<Integer> map(Set<Profile> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getProfile_id())
                .collect(Collectors.toSet());
    }

    @Named("profileIdsToProfile")
    Set<Profile> mapIdsToProfile(Set<Integer> id) {
        return id.stream()
                .map( i-> profileService.findById(i))
                .collect(Collectors.toSet());
    }

    @Mapping(target = "profiles", source = "profiles", qualifiedByName = "profileIdsToProfile")
    public abstract Goal goalDTOToGoal(GoalDTO goalDTO);

}