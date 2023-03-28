package com.example.mefit.Services.User;

import com.example.mefit.Models.AppUser;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.User;
import com.example.mefit.Services.CrudService;

import java.util.Collection;

public interface UserService extends CrudService<User,Integer> {

    Profile getProfile(Integer id);
}
