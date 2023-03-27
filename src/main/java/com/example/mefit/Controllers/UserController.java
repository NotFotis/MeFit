package com.example.mefit.Controllers;

import com.example.mefit.Mappers.UserMapper;
import com.example.mefit.Models.DTO.userDTO;
import com.example.mefit.Models.User;
import com.example.mefit.Services.User.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;


//    @GetMapping("info")
//    public ResponseEntity getLoggedInUserInfo(@AuthenticationPrincipal Jwt principal) {
//        Map<String, String> map = new HashMap<>();
//        map.put("subject", principal.getClaimAsString("sub"));
//        map.put("user_name", principal.getClaimAsString("preferred_username"));
//        map.put("email", principal.getClaimAsString("email"));
//        map.put("first_name", principal.getClaimAsString("given_name"));
//        map.put("last_name", principal.getClaimAsString("family_name"));
//        map.put("roles", String.valueOf(principal.getClaimAsStringList("roles")));
//        return ResponseEntity.ok(map);
//    }
//
//    @GetMapping("principal")
//    public ResponseEntity getUser(Principal user){
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("current")
//    public ResponseEntity getCurrentlyLoggedInUser(@AuthenticationPrincipal Jwt jwt) {
//        return ResponseEntity.ok(
//                userService.findById(
//                        jwt.getClaimAsString("sub")
//                )
//        );
//    }
//
//    @PostMapping("register")
//    public ResponseEntity addNewUserFromJwt(@AuthenticationPrincipal Jwt jwt) {
//        AppUser user = userService.add(jwt.getClaimAsString("sub"));
//        URI uri = URI.create("api/v1/users/" + user.getUid());
//        return ResponseEntity.created(uri).build();
//    }

    @RestController
    @RequestMapping(path = "api/v1/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public class UserController {

        private final UserService userService;
        private final UserMapper userMapper;

        public UserController(UserService userService, UserMapper userMapper) {
            this.userService = userService;
            this.userMapper = userMapper;
        }


        @GetMapping
        @Operation(summary = "Gets all Users")
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Success",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = userDTO.class)))
                        }
                )
        })
        public ResponseEntity findAll() {
            Collection<userDTO> user = userMapper.userToUserDTO(
                    userService.findAll()
            );
            return ResponseEntity.ok(user);
        }

        @GetMapping("{id}")
        @Operation(summary = "Gets a user by its ID")
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Success",
                        content = {
                                @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = userDTO.class))
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
            userDTO user = userMapper.userToUserDTO(userService.findById(id));

            return ResponseEntity.ok(user);
        }

        @PostMapping
        @Operation(summary = "Adds a new user")
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Created",
                        content = @Content
                )
        })

        public ResponseEntity<userDTO> add(@RequestBody userDTO entity) throws URISyntaxException {
            User addeduser = userService.add(userMapper.userDtoToUser(entity));
            userDTO addeduserDTO = userMapper.userToUserDTO(addeduser);

            URI uri = new URI("api/v1/user/" + addeduserDTO.getId());
            return ResponseEntity.created(uri).body(addeduserDTO);
        }


        @PatchMapping("{id}")
        @Operation(summary = "Updates a user")
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

        public ResponseEntity<userDTO> update(@PathVariable int id, @RequestBody userDTO userDTO) {
            User user = userMapper.userDtoToUser(userDTO);
            User updateduser = userService.update(id, user);
            userDTO updateduserDTO = userMapper.userToUserDTO(updateduser);
            return ResponseEntity.ok(updateduserDTO);
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Deletes a user by its ID")
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Success",
                        content = {
                                @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = userDTO.class))
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
            userService.deleteById(id);
        }
        public ResponseEntity getProfile(@PathVariable int id) {
            return ResponseEntity.ok(userService.getProfile(id));
        }

    }
