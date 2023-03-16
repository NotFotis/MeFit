package com.example.mefit.Controllers;

import com.example.mefit.Mappers.WorkoutMapper;
import com.example.mefit.Models.DTO.ExerciseDTO;
import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.jdbc.Work;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/workout")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final WorkoutMapper workoutMapper;

    public WorkoutController(WorkoutService workoutService, WorkoutMapper workoutMapper) {
        this.workoutService = workoutService;
        this.workoutMapper = workoutMapper;
    }

    @GetMapping
    @Operation(summary = "Gets all Workouts")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = WorkoutDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<WorkoutDTO> workout = workoutMapper.workoutToWorkoutDTO(
                workoutService.findAll()
        );
        return ResponseEntity.ok(workout);
    }
    @GetMapping("{id}")
    @Operation(summary = "Gets a workout by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WorkoutDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })

    public ResponseEntity findById(@PathVariable int id) {
        WorkoutDTO workout = workoutMapper.workoutToWorkoutDTO(workoutService.findById(id));

        return ResponseEntity.ok(workout);
    }
    @PostMapping
    @Operation(summary = "Adds a new workout")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })

    public ResponseEntity<WorkoutDTO> addWorkout(@RequestBody WorkoutDTO workoutDTO) {
        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDTO);
        Workout savedWorkout = workoutService.add(workout);
        WorkoutDTO savedWorkoutDTO = workoutMapper.workoutToWorkoutDTO(savedWorkout);
        return ResponseEntity.created(URI.create("api/v1/workout/" + savedWorkoutDTO.getId()))
                .body(savedWorkoutDTO);
    }


    @PatchMapping("{id}")
    @Operation(summary = "Updates a workout")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })

    public ResponseEntity<WorkoutDTO> update(@PathVariable int id, @RequestBody WorkoutDTO workoutDTO) {
        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDTO);
        Workout updatedWorkout = workoutService.update(id, workout);
        WorkoutDTO updatedWorkoutDTO = workoutMapper.workoutToWorkoutDTO(updatedWorkout);
        return ResponseEntity.ok(updatedWorkoutDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a workout by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WorkoutDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public void deleteById(@PathVariable int id) {
        workoutService.deleteById(id);
    }
    @GetMapping("{id}/exercise")
    @Operation(summary = "Gets workout Exercises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getExercise(@PathVariable int id) {
        return ResponseEntity.ok(workoutService.getExercise(id));
    }
    @GetMapping("{id}/program")
    @Operation(summary = "Gets workout Programs")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getProgram(@PathVariable int id) {
        return ResponseEntity.ok(workoutService.getProgram(id));
    }


}
