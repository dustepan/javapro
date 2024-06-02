package dudin.javapro.taskeight.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author SDudin
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "integration.payments")
public class IntegrationServiceProperties {
    private String url;
    private Duration connectTimeout;
    private Duration readTimeout;
}
