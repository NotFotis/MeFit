package com.example.mefit.Services.Goal;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Repositories.GoalRepository;
import com.example.mefit.Repositories.ProgramRepository;
import com.example.mefit.Repositories.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class GoalServiceImpl implements GoalService{
    private final Logger logger= LoggerFactory.getLogger(GoalServiceImpl.class);
    private final GoalRepository goalRepository;
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;

    public GoalServiceImpl(GoalRepository goalRepository, ProgramRepository programRepository, WorkoutRepository workoutRepository) {
        this.goalRepository = goalRepository;
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Goal findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Goal> findAll() {
        return null;
    }

    @Override
    public Goal add(Goal entity) {
        return null;
    }

    @Override
    public Goal update(Integer integer, Goal entity) {
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
    public Set<Workout> getWorkout(int Id) {
        return null;
    }
}
