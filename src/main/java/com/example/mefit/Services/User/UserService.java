package com.example.mefit.Services.User;

import com.example.mefit.Models.AppUser;

import java.util.Collection;

public interface UserService {
    AppUser findById(String uid);
    Collection<AppUser> findAll();
    AppUser add(String uid);
    AppUser add(AppUser user);
    void update(AppUser user);
    void delete(String uid);

}
