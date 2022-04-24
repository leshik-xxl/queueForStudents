package com.leshik.queueforstudents.exeption;

import com.leshik.queueforstudents.model.UserEntity;

public class ExistingLoginException extends QueueForStudentsException {

    public ExistingLoginException(UserEntity user) {
        super("Login already exists" + user.getLogin());
    }

}

