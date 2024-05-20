package ru.javapro.tasksix.tasksix.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.javapro.tasksix.tasksix.exception.handler.CustomExceptionHandler;
import ru.javapro.tasksix.tasksix.properties.ServiceCustomProperties;

/**
 * @author SDudin
 */
@Configuration
@EnableConfigurationProperties({ServiceCustomProperties.class})
public class RestTemplateCustomConfig {

    @Bean
    RestTemplate operationWithDBClient(ServiceCustomProperties properties,
                                       CustomExceptionHandler exceptionHandler) {
        return new RestTemplateBuilder()
                .rootUri(properties.getUrl())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .errorHandler(exceptionHandler)
                .build();
    }
}
