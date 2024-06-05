package dudin.javapro.taskeight.controller;

import dudin.javapro.taskeight.dto.ErrorResponse;
import dudin.javapro.taskeight.exception.TransferException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author SDudin
 */
@RestControllerAdvice
public class TransferMoneyControllerAdvice {
    @ExceptionHandler(TransferException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTransferException(TransferException e) {
        return new ErrorResponse(e.getMessage());
    }
}
