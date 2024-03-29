package com.example.mefit.Services.Goal;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.Program;
import com.example.mefit.Repositories.GoalRepository;
import com.example.mefit.Repositories.ProfileRepository;
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
    private final ProfileRepository profileRepository;

    public GoalServiceImpl(GoalRepository goalRepository, ProgramRepository programRepository, ProfileRepository profileRepository) {
        this.goalRepository = goalRepository;
        this.programRepository = programRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Goal findById(Integer id) {
        return goalRepository.findById(id).get();
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
    public Goal update(Integer id, Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
goalRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
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
