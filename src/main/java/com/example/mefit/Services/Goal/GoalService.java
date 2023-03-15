package com.example.mefit.Services.Goal;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.Program;
import com.example.mefit.Services.CrudService;

import java.util.Set;

public interface GoalService extends CrudService<Goal,Integer> {
    Goal findById(int id);

    Goal update(int id, Goal entity);

    void deleteById(int id);

    boolean exists(int id);

    Set<Program> getProgram(int Id);
    Set<Profile> getProfile(int Id);

}
