package com.lianyu.tech.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;

/**
 * @author bowen.zhang
 */
public final class ImageIOUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageIOUtil.class);

    public static byte[] readImageBytes(File imageFile) {
        try {
            if (imageFile == null || !imageFile.exists()) return new byte[0];
            return Files.readAllBytes(imageFile.toPath());
        } catch (Exception e) {
            LOGGER.error("readImageBytes error", e);
            return new byte[0];
        }
    }

    public static void writeToImage(byte[] imageBytes, String ext, File file) {
        if (imageBytes == null || imageBytes.length == 0 || file.exists()) return;
        try {
            file.getParentFile().mkdirs();

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            ImageIO.write(image, "jpg", file);
        } catch (Exception e) {
            LOGGER.error("writeToImage error", e);
        }
    }

    public static void delete(File imageFile) {
        try {
            if (imageFile == null || !imageFile.exists()) return;
            Files.delete(imageFile.toPath());
        } catch (Exception e) {
            LOGGER.error("readImageBytes error", e);
        }
    }

    public static byte[] getBytes(BufferedImage bufferedImage) {
        if (bufferedImage == null) return new byte[0];
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.flush();
            byte[] imageBytes = outputStream.toByteArray();
            outputStream.close();
            return imageBytes;
        } catch (Exception e) {
            LOGGER.error("readImageBytes error", e);
        }
        return new byte[0];
    }
}
