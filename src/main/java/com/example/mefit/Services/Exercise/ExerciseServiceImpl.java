package com.example.mefit.Services.Exercise;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Workout;
import com.example.mefit.Repositories.ExerciseRepository;
import com.example.mefit.Repositories.WorkoutRepository;
import com.example.mefit.Services.Goal.GoalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final Logger logger= LoggerFactory.getLogger(GoalServiceImpl.class);
    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Exercise findById(Integer id) {
        return exerciseRepository.findById(id).get();
    }


    @Override
    public Collection<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise add(Exercise entity) {
        return exerciseRepository.save(entity);
    }


    @Override
    public Exercise update(Integer id, Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
exerciseRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return exerciseRepository.existsById(id);
    }

    @Override
    public Workout getWorkout(int Id) {
        return exerciseRepository.findById(Id).get().getWorkout();
    }

}
