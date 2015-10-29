package com.lianyu.tech.backoffice;

import com.lianyu.tech.backoffice.image.ImageHandler;
import com.lianyu.tech.backoffice.image.file.FileImageHandler;
import com.lianyu.tech.common.DefaultDBConfig;
import com.lianyu.tech.core.http.HTTPClient;
import com.lianyu.tech.core.platform.web.DeploymentSettings;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

@Configuration
public class AppConfig extends DefaultDBConfig {
    @Inject
    Environment env;
    @Inject
    private DeploymentSettings deploymentSettings;

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

    @Bean
    public ImageServerSetting imageServerSetting() {
        ImageServerSetting imageServerSetting = new ImageServerSetting();
        String server = env.getProperty("image.server.url", "/");
        if (!StringUtils.hasText(server) || "/".equalsIgnoreCase(server)) {
            server = deploymentSettings.getDeploymentContext();
        }
        if (!server.endsWith("/")) {
            server = server + "/";
        }
        imageServerSetting.setImageServer(server);
        return imageServerSetting;
    }
}
