package com.lianyu.tech.common.vo.converter;

import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.core.platform.web.DeploymentSettings;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bowen
 */
@Service
public class ImageConverter {

    @Value("${image.server.url}")
    private String imageServer;

    public void buildImageFullUrl(List<Image> images) {
        if (CollectionUtils.isEmpty(images)) return;
        String server = getServer();
        for (Image image : images) {
            image.setUrl(combinePath(image.getUrl(), server));
        }
    }

    private String combinePath(String url, String server) {
        if (!StringUtils.hasText(url)) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(server);
        if (url.startsWith("/")) {
            builder.append(url.substring(1));
        } else {
            builder.append(url);
        }
        return builder.toString();
    }

    private String getServer() {
        String server = imageServer;
        if (!StringUtils.hasText(server) || "/".equalsIgnoreCase(server)) {
            server = DeploymentSettings.get().getDeploymentContext() + "/img/";
        }
        if (!server.endsWith("/")) {
            server = server + "/";
        }
        return server;
    }
}
