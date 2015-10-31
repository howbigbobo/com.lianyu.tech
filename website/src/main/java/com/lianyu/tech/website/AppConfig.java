package com.lianyu.tech.website;

import com.lianyu.tech.common.DefaultDBConfig;
import com.lianyu.tech.core.http.HTTPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

@Configuration
public class AppConfig extends DefaultDBConfig {
    @Inject
    Environment env;

    @Bean
    public HTTPClient httpClient() {
        HTTPClient httpClient = new HTTPClient();
        httpClient.enableConnectionPool();
        httpClient.enableKeepAlive();
        return httpClient;
    }
}
