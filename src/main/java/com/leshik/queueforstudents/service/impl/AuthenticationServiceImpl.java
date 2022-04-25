package com.leshik.queueforstudents.service.impl;

import com.leshik.queueforstudents.exeption.ExistingUserNameException;
import com.leshik.queueforstudents.model.UserEntity;
import com.leshik.queueforstudents.repository.UserRepository;
import com.leshik.queueforstudents.service.AuthenticationService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserEntity login(String userName) throws ExistingUserNameException {
        log.debug("login initial ...");
        Optional<UserEntity> foundUser = userRepository.findByUserName(userName);
        if (foundUser.isPresent()) {
            log.error("login failed : ");
            throw new ExistingUserNameException(foundUser.get());
        } else {
            log.debug("login success");
            return userRepository.save(new UserEntity(userName));
        }
    }

    @Transactional
    @Override
    public UserEntity logout(String userName) {
        userRepository.deleteByUserName(userName);
        log.debug("logout");
        return new UserEntity(userName);
    }
}
