package com.example.mefit.Services.Program;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
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

    public ProgramServiceImpl(ProgramRepository programRepository, WorkoutRepository workoutRepository) {
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Program findById(int id) {
        return programRepository.findById(id).get();
    }

    @Override
    public Program findById(Integer integer) {
        return null;
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
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public void deleteById(int id) {
programRepository.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
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
