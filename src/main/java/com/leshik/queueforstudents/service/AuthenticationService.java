package com.leshik.queueforstudents.service;

import com.leshik.queueforstudents.exeption.ExistingLoginException;
import com.leshik.queueforstudents.model.UserEntity;

public interface AuthenticationService {
    UserEntity login(String user) throws ExistingLoginException;
    void logout(String user);
}
