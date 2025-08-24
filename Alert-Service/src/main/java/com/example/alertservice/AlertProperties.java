package com.example.alertservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alert")
public class AlertProperties {
    private String websocketEndpoint;

    public String getWebsocketEndpoint() { return websocketEndpoint; }
    public void setWebsocketEndpoint(String websocketEndpoint) { this.websocketEndpoint = websocketEndpoint; }
}
