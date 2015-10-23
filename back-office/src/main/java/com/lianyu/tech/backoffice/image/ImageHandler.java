package com.lianyu.tech.backoffice.image;

/**
 * @author bowen.zhang
 */
public interface ImageHandler {
    String save(ImageEntity imageEntity);

    ImageEntity get(String path);

    void delete(String path);
}
