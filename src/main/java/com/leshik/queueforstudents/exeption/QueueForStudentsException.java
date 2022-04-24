package com.leshik.queueforstudents.exeption;

public abstract class QueueForStudentsException extends RuntimeException {

    public QueueForStudentsException(String message) {
        super(message);
    }

    public QueueForStudentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
