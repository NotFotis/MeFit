package com.example.mefit.Controllers;

import com.example.mefit.Mappers.ExerciseMapper;
import com.example.mefit.Models.DTO.ExerciseDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Services.Exercise.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
@CrossOrigin(origins = {"http://localhost:3000/", "https://my-fit-one.vercel.app/*", "https://my-fit-one.vercel.app","https://*.vercel.app/*","*"},
        allowedHeaders = { "Origin", "Accept", "X-Requested-With", "Content-Type",
                "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization" },
        exposedHeaders = { "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials", "Authorization" })
@RestController
@RequestMapping(path = "api/v1/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseMapper exerciseMapper;

    public ExerciseController(ExerciseService exerciseService, ExerciseMapper exerciseMapper) {
        this.exerciseService = exerciseService;
        this.exerciseMapper = exerciseMapper;
    }

    @GetMapping
    @Operation(summary = "Gets all Exercises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExerciseDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<ExerciseDTO> exercise = exerciseMapper.exerciseToExerciseDTO(
                exerciseService.findAll()
        );
        return ResponseEntity.ok(exercise);
    }
    @GetMapping("{id}")
    @Operation(summary = "Gets an exercise by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExerciseDTO.class))
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
        ExerciseDTO exercise = exerciseMapper.exerciseToExerciseDTO(exerciseService.findById(id));

        return ResponseEntity.ok(exercise);
    }
    @PostMapping
    @Operation(summary = "Adds a new exercise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })

    public ResponseEntity<ExerciseDTO> add(@RequestBody ExerciseDTO entity) throws URISyntaxException {
        Exercise addedExercise = exerciseService.add(exerciseMapper.exerciseDtoToExercise(entity));
        ExerciseDTO addedExerciseDTO = exerciseMapper.exerciseToExerciseDTO(addedExercise);

        URI uri = new URI("api/v1/exercise/" + addedExerciseDTO.getId());
        return ResponseEntity.created(uri).body(addedExerciseDTO);
    }


    @PatchMapping("{id}")
    @Operation(summary = "Updates an exercise")
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

    public ResponseEntity<ExerciseDTO> update(@PathVariable int id, @RequestBody ExerciseDTO exerciseDTO) {
        Exercise exerciseToUpdate = exerciseMapper.exerciseDtoToExercise(exerciseDTO);
        Exercise updatedExercise = exerciseService.update(id, exerciseToUpdate);
        ExerciseDTO updatedExerciseDTO = exerciseMapper.exerciseToExerciseDTO(updatedExercise);
        return ResponseEntity.ok(updatedExerciseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an exercise by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExerciseDTO.class))
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
        exerciseService.deleteById(id);
    }
    @GetMapping("{id}/workout")
    @Operation(summary = "Gets exercise Workouts")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getWorkout(@PathVariable int id) {
        return ResponseEntity.ok(exerciseService.getWorkout(id));
    }



}
