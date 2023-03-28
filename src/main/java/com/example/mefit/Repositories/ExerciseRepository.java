package com.example.mefit.Repositories;

import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
    <S extends Exercise> S save(S entity);
    Optional<Exercise> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
}
