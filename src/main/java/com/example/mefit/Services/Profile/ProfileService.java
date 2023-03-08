package com.example.mefit.Services.Profile;

import com.example.mefit.Models.*;
import com.example.mefit.Services.CrudService;
import org.hibernate.jdbc.Work;

public interface ProfileService extends CrudService<Profile,Integer> {
    Program getProgram(int Id);
    Goal getGoal(int Id);
    User getUser(int Id);
    Workout getWorkout(int Id);
}
