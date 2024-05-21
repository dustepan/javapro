package ru.javapro.tasksix.tasksix.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author SDudin
 */
@ConfigurationProperties(prefix = "integration.custom")
public class ServiceCustomProperties {
    private String url;
    private Duration connectTimeout;
    private Duration readTimeout;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getUrl() {
        return url;
    }

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }
}
