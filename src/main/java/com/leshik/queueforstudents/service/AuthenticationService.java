package com.leshik.queueforstudents.service;

import com.leshik.queueforstudents.exeption.ExistingUserNameException;
import com.leshik.queueforstudents.model.UserEntity;

public interface AuthenticationService {
    UserEntity login(String userName) throws ExistingUserNameException;
    UserEntity logout(String userName);
}
