package com.example.mefit.Repositories;

import com.example.mefit.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    <S extends Profile> S save(S entity);
    Optional<Profile> findById(int primaryKey);
    void deleteById(int primaryKey);
    boolean existsById(int primaryKey);
    Optional<Profile> findById(String primaryKey);
}
