package com.lianyu.tech.backoffice.image.file;

import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.ImageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author bowen.zhang
 */
public class FileImageHandler implements ImageHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileImageHandler.class);
    private static final PathMatchingResourcePatternResolver PATH_RESOLVER = new PathMatchingResourcePatternResolver();

    @Override
    public String save(ImageEntity imageEntity) {
        if (imageEntity == null || imageEntity.getImageBytes() == null || imageEntity.getImageBytes().length == 0) return null;
        String hash = ImagePathUtil.generateHash(imageEntity.getImageBytes());
        String filePath = ImagePathUtil.generatePath(hash, imageEntity.getImageType());
        File file = getFile(filePath);
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            ImageIOUtil.writeToImage(imageEntity.getImageBytes(), imageEntity.getImageType().getExt(), file);
        }
        return ImagePathUtil.getHashPath(hash, imageEntity.getImageType());
    }

    public File getFile(String fileName) {
        try {
            return PATH_RESOLVER.getResource("classpath:img/" + fileName).getFile();
        } catch (IOException ie) {
            LOGGER.warn("get file error: " + fileName, ie);
            return null;
        }
    }

    public byte[] get404() {
        try {
            File img = getFile("404.gif");
            return Files.readAllBytes(img.toPath());
        } catch (Exception e) {
            LOGGER.error("get 404 image error. ", e);
            return new byte[0];
        }
    }

    @Override
    public ImageEntity get(String path) {
        String filePath = ImagePathUtil.getFilePathByHashPath(path);
        File file = getFile(filePath);
        if (file != null && file.exists()) {
            byte[] bytes = ImageIOUtil.readImageBytes(file);
            ImageEntity imageEntity = new ImageEntity(bytes);
            imageEntity.setImageType(ImagePathUtil.getImageType(path));
            imageEntity.setPath(path);
            return imageEntity;
        }
        return null;
    }

    @Override
    public void delete(String path) {
        String filePath = ImagePathUtil.getFilePathByHashPath(path);
        File file = getFile(filePath);
        if (file != null && file.exists()) {
            ImageIOUtil.delete(file);
        }
    }
}
