package com.example.mefit.mappers;

import com.example.mefit.models.Profile;
import com.example.mefit.models.dtos.profile.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @Mapping(target = "goal", source = "goal.id")
    ProfileDTO profileToProfileDTO(Profile profile);

    Collection<ProfileDTO> profileToProfileDTO(Collection<Profile> profile);
}
