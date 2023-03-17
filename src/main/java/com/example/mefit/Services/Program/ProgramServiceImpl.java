package com.example.mefit.Services.Program;

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
public class ProgramServiceImpl implements ProgramService{
    private final Logger logger= LoggerFactory.getLogger(ProgramServiceImpl.class);
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;

    private final GoalRepository goalRepository;

    public ProgramServiceImpl(ProgramRepository programRepository, WorkoutRepository workoutRepository, GoalRepository goalRepository) {
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public Program findById(Integer id) {
        return programRepository.findById(id).get();
    }


    @Override
    public Collection<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Program add(Program entity) {
        return programRepository.save(entity);
    }

    @Override
    public Program update(Integer id, Program entity) {
        return programRepository.save(entity);
    }


    @Override
    public void deleteById(Integer id) {
programRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return programRepository.existsById(id);
    }

    @Override
    public Set<Workout> getWorkout(int id) {
        return programRepository.findById(id).get().getWorkout();
    }

    @Override
    public Set<Goal> getGoal(int id) {
        return programRepository.findById(id).get().getGoal();
    }

}
