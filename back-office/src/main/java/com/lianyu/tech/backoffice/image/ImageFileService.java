package com.lianyu.tech.backoffice.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author bowen.zhang
 */
@Service
public class ImageFileService {
    private final Logger logger = LoggerFactory.getLogger(ImageFileService.class.getName());
    private final PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

    public File getFile(String fileName) throws IOException {
        return pathMatchingResourcePatternResolver.getResource("classpath:img/" + fileName).getFile();
    }

    public byte[] get404() {
        try {
            File img = getFile("404.gif");
            return Files.readAllBytes(img.toPath());
        } catch (Exception e) {
            logger.error("get 404 image error. ", e);
            return new byte[0];
        }
    }
}
