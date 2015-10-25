package com.lianyu.tech.backoffice.image.file;

import com.lianyu.tech.backoffice.image.ImageType;
import com.lianyu.tech.core.util.DigestUtils;
import com.lianyu.tech.core.util.StringUtils;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @author bowen.zhang
 */
public final class ImagePathUtil {
    private static final String SALT = "com.lianyu.tech.2015";
    private static final Pattern NOT_HEX_PATTERN = Pattern.compile("[^a-f0-9]");

    public static String generateHash(byte[] bytes) {
        String byteHash = DigestUtils.md5(bytes);
        return DigestUtils.md5(byteHash + SALT);
    }

    public static String generatePath(String hash, ImageType imageType) {
        return generatePath(hash, imageType.getExt());
    }

    public static String generatePath(String hash, String ext) {
        if (!validatePath(hash)) return "";
        return Integer.parseInt(hash.substring(0, 2), 16) % 5 + File.separator + hash + "." + ext;
    }

    public static String getHashPath(String hash, ImageType imageType) {
        return hash + "." + imageType.getExt();
    }

    public static String getFilePathByHashPath(String hashPath) {
        if (!validatePath(hashPath)) return "";
        int index = hashPath.lastIndexOf('.');
        return generatePath(hashPath.substring(0, index), hashPath.substring(index + 1));
    }

    public static ImageType getImageType(String hashPath) {
        int index = hashPath.lastIndexOf('.');
        return ImageType.fromExt(hashPath.substring(index + 1));
    }

    public static String combinePath(String... paths) {
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

    private static boolean validatePath(String path) {
        return !StringUtils.hasText(path) && path.length() > 10 && !NOT_HEX_PATTERN.matcher(path.substring(0, 2)).find();
    }
}
