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
    public AppUser findById(String uid) {
        return userRepository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public Collection<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser add(String uid) throws URISyntaxException {
        // Prevents internal server error for duplicates
        if(userRepository.existsById(uid))
            throw new UserAlreadyExistsException();
        // Create new user
        AppUser user = new AppUser();
        user.setUid(uid);
        user.setComplete(false);

        ProfileDTO newProfile = new ProfileDTO();
        newProfile.setUser(uid);
        Profile addedProfile = profileService.add(profileMapper.profileDtoToProfile(newProfile));
        ProfileDTO addedProfileDTO = profileMapper.profileToProfileDTO(addedProfile);
        URI uri = new URI("api/v1/profile/" + addedProfileDTO.getId());
        //return ResponseEntity.created(uri).body(addedProfileDTO);

        return userRepository.save(user);
    }

    @Override
    public AppUser add(AppUser user) {
        if(userRepository.existsById(user.getUid()))
            throw new UserAlreadyExistsException();
        return userRepository.save(user);
    }

    @Override
    public void update(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String uid) {
        userRepository.deleteById(uid);
    }
}

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

}
