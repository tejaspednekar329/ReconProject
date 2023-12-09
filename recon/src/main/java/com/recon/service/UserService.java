package com.recon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recon.entity.User;
import com.recon.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // implement user creation logic
        return userRepository.save(user);
    }

    public void changePassword(Long userId, String newPassword) {
        // implement password change logic
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(user -> {
            user.setPassword(newPassword);
            userRepository.save(user);
        });
    }
}

