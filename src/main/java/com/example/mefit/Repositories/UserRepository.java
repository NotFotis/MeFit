package com.example.mefit.Repositories;

import com.example.mefit.Models.AppUser;
import com.example.mefit.Models.User;
import com.example.mefit.Models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    <S extends Workout> S save(S entity);
    Optional<User> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
}
