package ru.javapro.tasksix.tasksix.exception;

/**
 * @author SDudin
 */
public class ErrorDto {
    private String message;

    public ErrorDto() {
    }


    public ErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
