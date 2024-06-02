package dudin.javapro.taskeight.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author SDudin
 */
@Getter
@Setter
public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
