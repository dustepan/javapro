package ru.javapro.tasksix.tasksix.exception;

import lombok.EqualsAndHashCode;

/**
 * @author SDudin
 */
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomException(String message) {
        this.message = message;
    }
}
