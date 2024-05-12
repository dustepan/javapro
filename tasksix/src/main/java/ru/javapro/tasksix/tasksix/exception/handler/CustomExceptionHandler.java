package ru.javapro.tasksix.tasksix.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.javapro.tasksix.tasksix.exception.CustomException;
import ru.javapro.tasksix.tasksix.exception.ErrorDto;

import java.io.IOException;

/**
 * @author SDudin
 */
@Component
public class CustomExceptionHandler implements ResponseErrorHandler {
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
            ErrorDto errorDto = mapper.readValue(response.getBody(), ErrorDto.class);
            throw new CustomException(errorDto.getMessage());
        }
    }
}
