package com.example.mefit.Mappers;

import com.example.mefit.Models.AppUser;
import com.example.mefit.Models.DTO.ProfileDTO;
import com.example.mefit.Models.DTO.userDTO;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.User;
import com.example.mefit.Services.Goal.GoalService;
import com.example.mefit.Services.Profile.ProfileService;
import com.example.mefit.Services.User.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    protected ProfileService profileService;

    @Mapping(target = "profile", source = "profile.id")
    public abstract userDTO userToUserDTO(User user);
    public abstract Collection<userDTO> userToUserDTO(Collection<User> user);

    @Named("profileIdToProfile")
    Profile mapIdToProfile(int id) {
        return profileService.findById(id);
    }
    @Mapping(target = "profile", source = "profile", qualifiedByName="profileIdToProfile")
    public abstract User userDtoToUser(userDTO UserDTO);
}
