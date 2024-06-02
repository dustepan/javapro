package dudin.javapro.taskeight.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import dudin.javapro.taskeight.dto.ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author SDudin
 */
@Component
public class IntegrationExceptionHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError() ||
                response.getStatusCode().is5xxServerError()) {
            ObjectMapper mapper = new ObjectMapper();
            ErrorResponse errorDto = mapper.readValue(response.getBody(), ErrorResponse.class);
            throw new IntegrationException(errorDto.getErrorMessage());
        }
    }
}
