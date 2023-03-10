package com.example.mefit.Services.Program;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Repositories.ProgramRepository;
import com.example.mefit.Repositories.WorkoutRepository;
import com.example.mefit.Services.User.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class ProgramServiceImpl implements ProgramService{
    private final Logger logger= LoggerFactory.getLogger(ProgramServiceImpl.class);
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;

    public ProgramServiceImpl(ProgramRepository programRepository, WorkoutRepository workoutRepository) {
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Program findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Program> findAll() {
        return null;
    }

    @Override
    public Program add(Program entity) {
        return null;
    }

    @Override
    public Program update(Integer integer, Program entity) {
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
    public Set<Workout> getWorkout(int Id) {
        return null;
    }

    @Override
    public Set<Goal> getGoal(int Id) {
        return null;
    }

}
