package com.example.mefit.Services.Workout;

import com.example.mefit.Models.Exercise;
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
public class WorkoutServiceImpl implements WorkoutService{
    private final Logger logger= LoggerFactory.getLogger(WorkoutServiceImpl.class);
    private final WorkoutRepository workoutRepository;
    private final GoalRepository goalRepository;
    private final ProgramRepository programRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, GoalRepository goalRepository, ProgramRepository programRepository) {
        this.workoutRepository = workoutRepository;
        this.goalRepository = goalRepository;
        this.programRepository = programRepository;
    }

    @Override
    public Workout findById(int id) {
        return workoutRepository.findById(id).get();
    }

    @Override
    public Workout findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout add(Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public Workout update(Integer integer, Workout entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Workout update(int id, Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
workoutRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public boolean exists(int id) {
        return workoutRepository.existsById(id);
    }

    @Override
    public Set<Exercise> getExercise(int Id) {
        return workoutRepository.findById(Id).get().getExercise();
    }

    @Override
    public Set<Program> getProgram(int Id) {
        return workoutRepository.findById(Id).get().getProgram();
    }
}
