package com.example.mefit.Repositories;

import com.example.mefit.Models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Integer> {
    <S extends Goal> S save(S entity);
    Optional<Goal> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
}
