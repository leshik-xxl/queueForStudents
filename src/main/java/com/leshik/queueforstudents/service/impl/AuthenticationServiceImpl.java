package com.leshik.queueforstudents.service.impl;

import com.leshik.queueforstudents.exeption.ExistingLoginException;
import com.leshik.queueforstudents.model.User;
import com.leshik.queueforstudents.repository.UserRepository;
import com.leshik.queueforstudents.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) throws ExistingLoginException {
        Optional<User> foundUser = userRepository.findByLogin(user.getLogin());
        if (foundUser.isPresent()) {
            throw new ExistingLoginException(user);
        } else {
            return userRepository.save(new User(user.getLogin()));
        }
    }
}
