package com.example.mefit.Controllers;

import com.example.mefit.Mappers.GoalMapper;
import com.example.mefit.Models.DTO.ExerciseDTO;
import com.example.mefit.Models.DTO.GoalDTO;
import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Goal;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Goal.GoalService;
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
@RestController
@RequestMapping(path = "api/v1/goal")
@CrossOrigin(origins = {"http://localhost:3000/", "*.vercel.app/*"})
public class GoalController {
    private final GoalService goalService;
    private final GoalMapper goalMapper;

    public GoalController(GoalService goalService, GoalMapper goalMapper) {
        this.goalService = goalService;
        this.goalMapper = goalMapper;
    }


    @GetMapping
    @Operation(summary = "Gets all Goals")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = GoalDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<GoalDTO> goal = goalMapper.goalToGoalDTO(
                goalService.findAll()
        );
        return ResponseEntity.ok(goal);
    }
    @GetMapping("{id}")
    @Operation(summary = "Gets a goal by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GoalDTO.class))
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
        GoalDTO goal = goalMapper.goalToGoalDTO(goalService.findById(id));

        return ResponseEntity.ok(goal);
    }
    @PostMapping
    @Operation(summary = "Adds a new goal")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })

    public ResponseEntity<GoalDTO> add(@RequestBody GoalDTO entity) throws URISyntaxException {
        Goal addedGoal = goalService.add(goalMapper.goalDtoToGoal(entity));
        GoalDTO addedGoalDTO = goalMapper.goalToGoalDTO(addedGoal);

        URI uri = new URI("api/v1/goal/" + addedGoalDTO.getId());
        return ResponseEntity.created(uri).body(addedGoalDTO);
    }


    @PatchMapping("{id}")
    @Operation(summary = "Updates a goal")
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

    public ResponseEntity<GoalDTO> update(@PathVariable int id, @RequestBody GoalDTO goalDTO) {
        Goal goalToUpdate = goalMapper.goalDtoToGoal(goalDTO);
        Goal updatedGoal = goalService.update(id, goalToUpdate);
        GoalDTO updatedGoalDTO = goalMapper.goalToGoalDTO(updatedGoal);
        return ResponseEntity.ok(updatedGoalDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a goal by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GoalDTO.class))
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
        goalService.deleteById(id);
    }
    @GetMapping("{id}/program")
    @Operation(summary = "Gets program Goals")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getProgram(@PathVariable int id) {
        return ResponseEntity.ok(goalService.getProgram(id));
    }

    @GetMapping("{id}/profile")
    @Operation(summary = "Gets profile Goals")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getProfile(@PathVariable int id) {
        return ResponseEntity.ok(goalService.getProfile(id));
    }


}
