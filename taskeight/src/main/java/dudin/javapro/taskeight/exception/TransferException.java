package dudin.javapro.taskeight.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author SDudin
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class TransferException extends RuntimeException {
    private final String message;

    public TransferException(String message) {
        this.message = message;
    }
}
