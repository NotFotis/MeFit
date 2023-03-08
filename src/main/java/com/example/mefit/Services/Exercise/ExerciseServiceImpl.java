package com.example.mefit.Services.Exercise;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Repositories.ExerciseRepository;
import com.example.mefit.Services.Goal.GoalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final Logger logger= LoggerFactory.getLogger(GoalServiceImpl.class);
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Exercise> findAll() {
        return null;
    }

    @Override
    public Exercise add(Exercise entity) {
        return null;
    }

    @Override
    public Exercise update(Integer integer, Exercise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
