package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.backoffice.exception.ImageUploadException;
import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.ImageHandlerService;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class ImageFacadeService {
    @Inject
    private ImageHandlerService imageHandlerService;
    @Inject
    private ImageService imageService;

    @Value("${image.maxSize}")
    private Long imageLimitSize;

    public Image add(ImageEntity imageEntity) {
        if (imageEntity == null) return null;
        validate(imageEntity);

        String url = imageHandlerService.add(imageEntity);
        if (!StringUtils.hasText(url)) return null;

        Image image = imageService.getByUrl(url);
        if (image != null) return image;

        image = new Image();
        image.setUrl(url);
        image.setBytes(imageEntity.getImageBytes().length);
        imageService.add(image);
        return image;
    }

    public void delete(List<Integer> imageIds) {
        if (CollectionUtils.isEmpty(imageIds)) return;
        List<Image> images = imageService.findByIds(imageIds);
        if (CollectionUtils.isEmpty(images)) return;

        for (Image image : images) {
            imageHandlerService.delete(image.getUrl());
        }
        imageService.deleteByIds(imageIds);
    }

    public void delete(Integer imageId) {
        if (imageId == null) return;
        delete(Arrays.asList(imageId));
    }

    private void validate(ImageEntity imageEntity) {
        if (imageEntity.getImageBytes().length > imageLimitSize)
            throw new ImageUploadException("图片大小必须小于" + imageLimitSize + "B");
    }
}
