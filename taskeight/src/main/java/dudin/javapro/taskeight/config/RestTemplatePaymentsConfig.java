package dudin.javapro.taskeight.config;

import dudin.javapro.taskeight.exception.IntegrationExceptionHandler;
import dudin.javapro.taskeight.properties.IntegrationServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SDudin
 */
@Configuration
@EnableConfigurationProperties(IntegrationServiceProperties.class)
public class RestTemplatePaymentsConfig {
    @Bean
    RestTemplate paymentsClient(IntegrationServiceProperties properties,
                                IntegrationExceptionHandler exceptionHandler) {
        return new RestTemplateBuilder()
                .rootUri(properties.getUrl())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .errorHandler(exceptionHandler)
                .build();
    }
}
