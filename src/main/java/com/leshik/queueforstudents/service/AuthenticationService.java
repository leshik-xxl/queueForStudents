package com.leshik.queueforstudents.service;

import com.leshik.queueforstudents.exeption.ExistingLoginException;
import com.leshik.queueforstudents.model.User;

public interface AuthenticationService {
    User login(User user) throws ExistingLoginException;
}
