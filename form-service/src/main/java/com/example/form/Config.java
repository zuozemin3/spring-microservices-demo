package com.example.form;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class Config {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    public String getDbUrl() {
        return dbUrl;
    }
}
