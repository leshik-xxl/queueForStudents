package com.leshik.queueforstudents.exeption;

public class NotFoundUserException extends QueueForStudentsException {

    public NotFoundUserException(String userName) {
        super("User ' " + userName + " ' not found");
    }

}
