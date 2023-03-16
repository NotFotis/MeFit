package com.example.mefit.services.goal;

import com.example.mefit.models.Profile;
import com.example.mefit.models.Goal;
import com.example.mefit.services.CrudService;

import java.util.Collection;

public interface GoalService extends CrudService<Goal, Integer> {
    Goal update(int id, Goal entity);

    Collection<Profile> getProfiles(int goalId);
    void updateProfiles(int goalId, int[] profilesIds);
}
