package com.example.mefit.Services.Profile;

import com.example.mefit.Models.*;
import com.example.mefit.Services.CrudService;
import org.hibernate.jdbc.Work;

public interface ProfileService extends CrudService<Profile,Integer> {

    Goal getGoal(int Id);



    User getUser(Integer id);
}
