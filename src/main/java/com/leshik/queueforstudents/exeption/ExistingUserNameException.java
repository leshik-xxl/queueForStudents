package com.leshik.queueforstudents.exeption;

import com.leshik.queueforstudents.model.UserEntity;

public class ExistingUserNameException extends QueueForStudentsException {

    public ExistingUserNameException(UserEntity user) {
        super("Username already exists" + user.getUserName());
    }

}


