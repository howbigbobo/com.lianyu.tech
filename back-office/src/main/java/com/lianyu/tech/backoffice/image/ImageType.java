package com.lianyu.tech.backoffice.image;

/**
 * @author bowen.zhang
 */
public enum ImageType {
    JPEG,
    PNG,
    GIF,
    BMP;

    public String getExt() {
        switch (this) {
            case GIF:
                return "gif";
            case JPEG:
                return "jpg";
            case PNG:
                return "png";
            case BMP:
                return "bmp";
            default:
                return "jpg";
        }
    }

    public static ImageType fromExt(String ext) {
        String ext1 = ext.toLowerCase();
        switch (ext1) {
            case "gif":
                return GIF;
            case "jpg":
                return JPEG;
            case "png":
                return PNG;
            case "bmp":
                return BMP;
            default:
                return JPEG;
        }
    }
}
