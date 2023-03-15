package com.example.mefit.Services.Goal;

import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.CrudService;

import java.util.Set;

public interface GoalService extends CrudService<Goal,Integer> {
    Program getProgram(int Id);
    Set<Profile> getProfile(int Id);

}
