package com.example.mefit.Services.User;

import com.example.mefit.Exceptions.UserAlreadyExistsException;
import com.example.mefit.Exceptions.UserNotFoundException;
import com.example.mefit.Mappers.ProfileMapper;
import com.example.mefit.Models.AppUser;
import com.example.mefit.Models.DTO.ProfileDTO;
import com.example.mefit.Models.Profile;
import com.example.mefit.Repositories.UserRepository;
import com.example.mefit.Services.Profile.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public UserServiceImpl(UserRepository userRepository, ProfileService profileService, ProfileMapper profileMapper) {
        this.userRepository = userRepository;
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

//    @Override
//    public User add(Integer id) {
//        // Prevents internal server error for duplicates
//        if(userRepository.existsById(id))
//            throw new UserAlreadyExistsException();
//        // Create new user
//        User user = new User();
//        user.setId(id);
//        user.setAdmin(false);
//        user.setContributor(false);
//        return userRepository.save(user);
//    }

    @Override
    public User add(User entity) {
        ProfileDTO newProfile = new ProfileDTO();
        newProfile.setUser(uid);
        Profile addedProfile = profileService.add(profileMapper.profileDtoToProfile(newProfile));
        ProfileDTO addedProfileDTO = profileMapper.profileToProfileDTO(addedProfile);
        URI uri = new URI("api/v1/profile/" + addedProfileDTO.getId());
        //return ResponseEntity.created(uri).body(addedProfileDTO);
        return userRepository.save(entity);
    }

    @Override
    public User update(Integer id, User user) {
      return  userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer integer) {
        return userRepository.existsById(integer);
    }

    @Override
    public Profile getProfile(Integer id) {
        return null;
    }
}

