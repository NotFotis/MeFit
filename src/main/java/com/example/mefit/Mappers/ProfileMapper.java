package com.example.mefit.Mappers;

import com.example.mefit.Models.DTO.ProfileDTO;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Services.Goal.GoalService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ProfileMapper {
    @Autowired
    protected GoalService goalService;

    @Mapping(target = "goal", source = "goal.id")
    public abstract ProfileDTO profileToProfileDTO(Profile profile);
    public abstract Collection<ProfileDTO> profileToProfileDTO(Collection<Profile> profile);

    @Named("goalIdToGoal")
    Goal mapIdToGoal(int id) {
        return goalService.findById(id);
    }
    @Mapping(target = "goal", source = "goal", qualifiedByName="goalIdToGoal")
    public abstract Profile profileDtoToProfile(ProfileDTO profileDTO);
}
