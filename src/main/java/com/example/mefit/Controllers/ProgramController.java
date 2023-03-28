package com.example.mefit.Controllers;

import com.example.mefit.Mappers.ProgramMapper;
import com.example.mefit.Models.DTO.ProgramDTO;
import com.example.mefit.Models.DTO.WorkoutDTO;
import com.example.mefit.Models.Program;
import com.example.mefit.Models.Workout;
import com.example.mefit.Services.Program.ProgramService;
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
@RequestMapping(path = "api/v1/program")
@CrossOrigin(origins = {"http://localhost:3000/", "https://my-fit-one.vercel.app/*", "https://my-fit-one.vercel.app/**"})
public class ProgramController {
    private final ProgramService programService;
    private final ProgramMapper programMapper;

    public ProgramController(ProgramService programService, ProgramMapper programMapper) {
        this.programService = programService;
        this.programMapper = programMapper;
    }


    @GetMapping
    @Operation(summary = "Gets all Programs")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProgramDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<ProgramDTO> program = programMapper.programToProgramDTO(
                programService.findAll()
        );
        return ResponseEntity.ok(program);
    }
    @GetMapping("{id}")
    @Operation(summary = "Gets a program by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProgramDTO.class))
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
        ProgramDTO program = programMapper.programToProgramDTO(programService.findById(id));

        return ResponseEntity.ok(program);
    }
    @PostMapping
    @Operation(summary = "Adds a new program")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })

    public ResponseEntity<ProgramDTO> add(@RequestBody ProgramDTO entity)throws URISyntaxException {
        Program savedprogram = programService.add(programMapper.programDtoToProgram(entity));
        ProgramDTO result = programMapper.programToProgramDTO(savedprogram);
        URI uri = new URI("api/v1/program/" + result.getId());
        return ResponseEntity.created(uri).body(result);
    }


    @PatchMapping("{id}")
    @Operation(summary = "Updates a program")
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

    public ResponseEntity<ProgramDTO> update(@PathVariable int id, @RequestBody ProgramDTO programDTO) {
        Program program = programMapper.programDtoToProgram(programDTO);
        Program updatedProgram = programService.update(id, program);
        ProgramDTO updatedProgramDTO = programMapper.programToProgramDTO(updatedProgram);
        return ResponseEntity.ok(updatedProgramDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a program by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProgramDTO.class))
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
        programService.deleteById(id);
    }
    @GetMapping("{id}/workout")
    @Operation(summary = "Gets program Workouts")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getWorkout(@PathVariable int id) {
        return ResponseEntity.ok(programService.getWorkout(id));
    }
    @GetMapping("{id}/goal")
    @Operation(summary = "Gets program Goals")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content
            )
    })
    public ResponseEntity getGoal(@PathVariable int id) {
        return ResponseEntity.ok(programService.getGoal(id));
    }

}
