package com.lianyu.tech.backoffice.web.converter;

import com.lianyu.tech.backoffice.ImageServerSetting;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class ImageConverter {
    @Inject
    private ImageServerSetting imageServerSetting;

    public void buildImageFullUrl(List<Image> images) {
        if (CollectionUtils.isEmpty(images)) return;
        for (Image image : images) {
            image.setUrl(combinePath(image.getUrl()));
        }
    }

    private String combinePath(String url) {
        if (!StringUtils.hasText(url)) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(imageServerSetting.getImageServer());
        if (!url.startsWith("/")) {
            builder.append(url.substring(1));
        }
        return builder.toString();
    }
}
