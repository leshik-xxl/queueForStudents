package com.leshik.queueforstudents.service.impl;

import com.leshik.queueforstudents.exeption.ExistingUserNameException;
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
    public UserEntity login(String userName) throws ExistingUserNameException {
        Optional<UserEntity> foundUser = userRepository.findByUserName(userName);
        if (foundUser.isPresent()) {
            throw new ExistingUserNameException(foundUser.get());
        } else {
            return userRepository.save(new UserEntity(userName));
        }
    }

    @Transactional
    @Override
    public UserEntity logout(String userName) {
        userRepository.deleteByUserName(userName);
        return new UserEntity(userName);
    }
}
