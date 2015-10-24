package com.lianyu.tech.backoffice.image.file;

import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.ImageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.util.WebUtils;

import java.io.File;
import java.nio.file.Files;

/**
 * @author bowen.zhang
 */
public class FileImageHandler implements ImageHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileImageHandler.class);
    private static final PathMatchingResourcePatternResolver PATH_RESOLVER = new PathMatchingResourcePatternResolver();
    private static final String IMAGE_PATH = "images";

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
            String rootPath = System.getProperty(WebUtils.DEFAULT_WEB_APP_ROOT_KEY);
            String fullPath = combinePath(rootPath, IMAGE_PATH, fileName);
            return new File(fullPath);
        } catch (Exception ie) {
            LOGGER.warn("get file error: " + fileName, ie);
            return null;
        }
    }

    private String combinePath(String... paths) {
        if (paths.length == 1) return paths[0];
        StringBuilder builder = new StringBuilder();
        String separator = File.separator;
        int count = 0;
        for (String p : paths) {
            int startIndex = 0;
            int endIndex = p.length();
            if (p.startsWith(separator)) {
                startIndex = 1;
            }
            if (p.endsWith(separator)) {
                endIndex = p.length() - 1;
            }
            builder.append(p.substring(startIndex, endIndex));
            count++;
            if (count < paths.length) builder.append(separator);
        }
        return builder.toString();
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
