package com.lianyu.tech.backoffice;

import com.lianyu.tech.backoffice.image.ImageHandler;
import com.lianyu.tech.backoffice.image.file.FileImageHandler;
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

    @Bean
    public ImageHandler imageHandler() {
        return new FileImageHandler();
    }
}
