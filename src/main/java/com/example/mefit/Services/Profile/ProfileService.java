package com.example.mefit.Services.Profile;

import com.example.mefit.Models.*;
import com.example.mefit.Services.CrudService;
import org.hibernate.jdbc.Work;

public interface ProfileService extends CrudService<Profile,Integer> {

    Profile findById(int id);

    Profile update(int id, Profile entity);

    void deleteById(int id);

    boolean exists(int id);

    Goal getGoal(int Id);


}
