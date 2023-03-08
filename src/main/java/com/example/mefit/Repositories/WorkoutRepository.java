package com.example.mefit.Repositories;
import com.example.mefit.Models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
    <S extends Workout> S save(S entity);
    Optional<Workout> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
}
