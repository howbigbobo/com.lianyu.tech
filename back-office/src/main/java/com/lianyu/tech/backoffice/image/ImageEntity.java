package com.lianyu.tech.backoffice.image;

/**
 * @author bowen.zhang
 */
public class ImageEntity {
    private String path;
    private byte[] imageBytes;
    private ImageType imageType;

    public ImageEntity() {
    }

    public ImageEntity(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
