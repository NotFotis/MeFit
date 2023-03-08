package com.example.mefit.Repositories;

import com.example.mefit.Models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program,Integer> {
    <S extends Program> S save(S entity);
    Optional<Program> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
}
