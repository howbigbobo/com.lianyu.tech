package com.lianyu.tech.backoffice.image.file;

import com.lianyu.tech.backoffice.image.ImageType;
import com.lianyu.tech.core.util.DigestUtils;

/**
 * @author bowen.zhang
 */
public final class ImagePathUtil {
    private static final String SALT = "com.lianyu.tech.2015";

    public static String generateHash(byte[] bytes) {
        String byteHash = DigestUtils.md5(bytes);
        return DigestUtils.md5(byteHash + SALT);
    }

    public static String generatePath(String hash, ImageType imageType) {
        return generatePath(hash, imageType.getExt());
    }

    public static String generatePath(String hash, String ext) {
        return hash.substring(0, 2) + "/" + hash.substring(2, 4) + "/" + hash.substring(4, hash.length()) + "." + ext;
    }

    public static String getHashPath(String hash, ImageType imageType) {
        return hash + "." + imageType.getExt();
    }

    public static String getFilePathByHashPath(String hashPath) {
        int index = hashPath.lastIndexOf('.');
        return generatePath(hashPath.substring(0, index), hashPath.substring(index));
    }

    public static ImageType getImageType(String hashPath) {
        int index = hashPath.lastIndexOf('.');
        return ImageType.fromExt(hashPath.substring(index + 1));
    }
}
