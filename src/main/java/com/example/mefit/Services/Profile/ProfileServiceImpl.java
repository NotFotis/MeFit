package com.example.mefit.Services.Profile;

import com.example.mefit.Models.*;
import com.example.mefit.Repositories.GoalRepository;
import com.example.mefit.Repositories.ProgramRepository;
import com.example.mefit.Repositories.WorkoutRepository;
import com.example.mefit.Services.Program.ProgramServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class ProfileServiceImpl implements ProfileService{
    private final Logger logger= LoggerFactory.getLogger(ProgramServiceImpl.class);
    private final ProgramRepository programRepository;
    private final ProfileService profileService;
    private final WorkoutRepository workoutRepository;
    private final GoalRepository goalRepository;

    public ProfileServiceImpl(ProgramRepository programRepository, ProfileService profileService, WorkoutRepository workoutRepository, GoalRepository goalRepository) {
        this.programRepository = programRepository;
        this.profileService = profileService;
        this.workoutRepository = workoutRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public Profile findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Profile> findAll() {
        return null;
    }

    @Override
    public Profile add(Profile entity) {
        return null;
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
    public Program getProgram(int Id) {
        return null;
    }

    @Override
    public Goal getGoal(int Id) {
        return null;
    }

    @Override
    public User getUser(int Id) {
        return null;
    }

    @Override
    public Workout getWorkout(int Id) {
        return null;
    }
}
