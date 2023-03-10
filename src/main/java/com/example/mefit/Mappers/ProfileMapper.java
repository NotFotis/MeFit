package com.example.mefit.Mappers;

import com.example.mefit.Services.Goal.GoalService;
import com.example.mefit.Services.User.UserService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ProfileMapper {
    @Autowired
    protected UserService userService;
    @Autowired
    protected GoalService goalService;

}
