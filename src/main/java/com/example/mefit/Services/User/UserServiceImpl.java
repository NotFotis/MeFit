package com.example.mefit.Services.User;

import com.example.mefit.Exceptions.UserAlreadyExistsException;
import com.example.mefit.Exceptions.UserNotFoundException;
import com.example.mefit.Models.Profile;
import com.example.mefit.Models.User;
import com.example.mefit.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

