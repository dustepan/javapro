package dudin.javapro.taskeight.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SDudin
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class IntegrationException extends RuntimeException{
    private final String message;

    public IntegrationException(String message) {
        this.message = message;
    }
}
