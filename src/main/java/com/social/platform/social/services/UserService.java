package com.social.platform.social.services;

import com.social.platform.social.entities.User;
import com.social.platform.social.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user) {
        // Save here
        userRepository.save(user);
    }
}
