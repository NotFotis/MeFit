package com.example.mefit.controllers;

import com.example.mefit.models.Exercise;
import com.example.mefit.services.exercise.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<Collection<Exercise>> getAll() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Exercise exercise) {
        exerciseService.add(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
