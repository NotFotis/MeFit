package com.example.mefit.Services.Workout;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Repositories.GoalRepository;
import com.example.mefit.Repositories.ProgramRepository;
import com.example.mefit.Repositories.WorkoutRepository;
import com.example.mefit.Services.User.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class WorkoutServiceImpl implements WorkoutService{
    private final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    private final WorkoutRepository workoutRepository;
    private final GoalRepository goalRepository;
    private final ProgramRepository programRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, GoalRepository goalRepository, ProgramRepository programRepository) {
        this.workoutRepository = workoutRepository;
        this.goalRepository = goalRepository;
        this.programRepository = programRepository;
    }

    @Override
    public Workout findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Workout> findAll() {
        return null;
    }

    @Override
    public Workout add(Workout entity) {
        return null;
    }

    @Override
    public Workout update(Integer integer, Workout entity) {
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
    public Set<Goal> getGoal(int Id) {
        return null;
    }

    @Override
    public Set<Program> getProgram(int Id) {
        return null;
    }
}
