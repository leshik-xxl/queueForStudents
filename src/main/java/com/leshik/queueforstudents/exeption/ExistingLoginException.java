package com.leshik.queueforstudents.exeption;

import com.leshik.queueforstudents.model.User;

public class ExistingLoginException extends QueueForStudentsException {

    public ExistingLoginException(User user) {
        super("Login already exists" + user.getLogin());
    }

}

