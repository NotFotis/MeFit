package com.example.mefit.Services.Goal;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.Program;
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
    public Goal findById(int id) {
        return goalRepository.findById(id).get();
    }

    @Override
    public Goal findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal add(Goal entity) {
        return goalRepository.save(entity);
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
    public Goal update(int id, Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
goalRepository.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
        return goalRepository.existsById(id);
    }

    @Override
    public Set<Program> getProgram(int Id) {
        return goalRepository.findById(Id).get().getProgram();
    }

    @Override
    public Set<Profile> getProfile(int Id) {
        return goalRepository.findById(Id).get().getProfile();
    }
}
