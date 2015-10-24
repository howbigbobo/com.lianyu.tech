package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.common.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ImageService {
    @Inject
    private ImageRepository imageRepository;

    public List<Image> findByIds(List<Integer> imageIds) {
        return imageRepository.findByIds(imageIds);
    }

    public Image getByUrl(String url) {
        return imageRepository.getByUrl(url);
    }

    @Transactional
    public void add(Image image) {
        image.setCreateTime(new Date());
        image.setCreateUser("");
        imageRepository.create(image);
    }

    @Transactional
    public void deleteByIds(List<Integer> imageIds) {
        List<Image> images = imageRepository.findByIds(imageIds);
        if (CollectionUtils.isEmpty(images)) return;
        for (Image image : images) {
            imageRepository.delete(image);
        }
    }
}
