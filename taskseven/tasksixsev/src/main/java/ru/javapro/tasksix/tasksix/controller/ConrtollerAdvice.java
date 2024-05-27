package ru.javapro.tasksix.tasksix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.javapro.tasksix.tasksix.exception.CustomException;
import ru.javapro.tasksix.tasksix.exception.ErrorDto;

/**
 * @author SDudin
 */
@RestControllerAdvice
public class ConrtollerAdvice {
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleCustomException(CustomException e) {
        return new ErrorDto(e.getMessage());
    }
}
