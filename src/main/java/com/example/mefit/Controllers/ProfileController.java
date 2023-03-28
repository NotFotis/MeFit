package com.example.mefit.Controllers;

import com.example.mefit.Mappers.ProfileMapper;
import com.example.mefit.Models.DTO.ExerciseDTO;
import com.example.mefit.Models.DTO.ProfileDTO;
import com.example.mefit.Models.Exercise;
import com.example.mefit.Models.Profile;
import com.example.mefit.Services.Profile.ProfileService;
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
@RequestMapping(path = "api/v1/profile")
@CrossOrigin(origins = {"http://localhost:3000/", "*.vercel.app/*"})
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }


    @GetMapping
    @Operation(summary = "Gets all Profiles")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<ProfileDTO> profile = profileMapper.profileToProfileDTO(
                profileService.findAll()
        );
        return ResponseEntity.ok(profile);
    }
    @GetMapping("{id}")
    @Operation(summary = "Gets a profile by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProfileDTO.class))
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
        ProfileDTO profile = profileMapper.profileToProfileDTO(profileService.findById(id));

        return ResponseEntity.ok(profile);
    }
    @PostMapping
    @Operation(summary = "Adds a new profile")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })

    public ResponseEntity<ProfileDTO> add(@RequestBody ProfileDTO entity) throws URISyntaxException {
        Profile addedProfile = profileService.add(profileMapper.profileDtoToProfile(entity));
        ProfileDTO addedProfileDTO = profileMapper.profileToProfileDTO(addedProfile);

        URI uri = new URI("api/v1/profile/" + addedProfileDTO.getId());
        return ResponseEntity.created(uri).body(addedProfileDTO);
    }


    @PatchMapping("{id}")
    @Operation(summary = "Updates a profile")
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

    public ResponseEntity<ProfileDTO> update(@PathVariable int id, @RequestBody ProfileDTO profileDTO) {
        Profile profile = profileMapper.profileDtoToProfile(profileDTO);
        Profile updatedProfile = profileService.update(id, profile);
        ProfileDTO updatedProfileDTO = profileMapper.profileToProfileDTO(updatedProfile);
        return ResponseEntity.ok(updatedProfileDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a profile by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProfileDTO.class))
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
        profileService.deleteById(id);
    }
    @GetMapping("{id}/goal")
    @Operation(summary = "Gets profile Goal")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity getGoal(@PathVariable int id) {
        return ResponseEntity.ok(profileService.getGoal(id));
    }


}
