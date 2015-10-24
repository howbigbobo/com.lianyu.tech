package com.lianyu.tech.backoffice.exception;

/**
 * @author bowen
 */
public class ImageUploadException extends RuntimeException {

    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(String message, Exception e) {
        super(message, e);
    }
}
