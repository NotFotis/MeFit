package com.example.mefit.Services.Profile;

import com.example.mefit.Models.*;
import com.example.mefit.Repositories.GoalRepository;
import com.example.mefit.Repositories.ProfileRepository;
import com.example.mefit.Services.Program.ProgramServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ProfileServiceImpl implements ProfileService{
    private final Logger logger= LoggerFactory.getLogger(ProgramServiceImpl.class);
    private final ProfileRepository profileRepository;

    private final GoalRepository goalRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository, GoalRepository goalRepository) {
        this.profileRepository = profileRepository;

        this.goalRepository = goalRepository;
    }

    @Override
    public Profile findById(int id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Profile findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile add(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public Profile update(Integer integer, Profile entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public Profile update(int id, Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
profileRepository.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
        return profileRepository.existsById(id);
    }



    @Override
    public Goal getGoal(int id) {
        return profileRepository.findById(id).get().getGoal();
    }




}
