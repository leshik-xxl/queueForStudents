package com.leshik.queueforstudents.service.impl;

import com.leshik.queueforstudents.exeption.ExistingLoginException;
import com.leshik.queueforstudents.model.UserEntity;
import com.leshik.queueforstudents.repository.UserRepository;
import com.leshik.queueforstudents.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserEntity login(String user) throws ExistingLoginException {
        Optional<UserEntity> foundUser = userRepository.findByLogin(user);
        if (foundUser.isPresent()) {
            throw new ExistingLoginException(new UserEntity(user));
        } else {
            return userRepository.save(new UserEntity(user));
        }
    }

    @Transactional
    @Override
    public void logout(String user) {
        userRepository.deleteByLogin(user);
    }
}
