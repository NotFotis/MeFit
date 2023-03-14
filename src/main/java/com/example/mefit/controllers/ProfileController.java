package com.example.mefit.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.example.mefit.mappers.ProfileMapper;
import com.example.mefit.models.Profile;
import com.example.mefit.models.dtos.profile.ProfileDTO;
import com.example.mefit.services.profile.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;


    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }
    @Operation(summary = "Get all Movies")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No Profiles to see",
                    content = @Content)
    })
    public ResponseEntity findall() {
        return ResponseEntity.ok(profileMapper.profileToProfileDTO(profileService.findAll()));
    }

    @Operation(summary = "Get specific Profile")
    @GetMapping("{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfileDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Profile does not exist with supplied ID",
                    content = @Content)
    })
    public ResponseEntity findByid(@PathVariable int id){
        return ResponseEntity.ok(profileMapper.profileToProfileDTO(profileService.findById(id)));
    }

    @Operation(summary = "Add a new Profile")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody ProfileDTO profileDTO) throws URISyntaxException {
        Profile profile = new Profile();
        profile.setAge(profileDTO.getAge());
        profile.setGoal(profileDTO.getGoal());
        profile.setHeight(profileDTO.getHeight());
        profile.setWeight(profileDTO.getWeight());

        profileService.add(profile);
        URI uri = new URI("api/v1/profiles/");
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update a Profile")
    @PutMapping("{id}")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Movie successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Movie not found with supplied ID",
                    content = @Content)
    })
    public ResponseEntity update(@RequestBody Profile entity,@PathVariable int id){
        if(id != entity.getProfile_id())
            return ResponseEntity.badRequest().build();
        profileService.update(entity);
        return ResponseEntity.noContent().build();
    }
}
