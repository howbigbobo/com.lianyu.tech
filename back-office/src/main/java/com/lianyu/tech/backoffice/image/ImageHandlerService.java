package com.lianyu.tech.backoffice.image;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author bowen.zhang
 */
@Service
public class ImageHandlerService {
    private final Logger logger = LoggerFactory.getLogger(ImageHandlerService.class.getName());

    @Inject
    private ImageHandler imageHandler;

    public ImageEntity get(String path) {
        if (!StringUtils.hasText(path)) return null;
        return imageHandler.get(path);
    }

    public String add(ImageEntity image) {
        if (image == null || image.getImageBytes() == null || image.getImageBytes().length == 0) {
            return "";
        }
        return imageHandler.save(image);
    }

    public boolean delete(String path) {
        if (!StringUtils.hasText(path)) return false;
        imageHandler.delete(path);
        return true;
    }

    public ImageEntity resize(ImageEntity image, ImageSize size) {
        if (image == null || size == null || image.getImageBytes() == null
                || image.getImageBytes().length == 0 || size.getWidth() <= 0) {
            return image;
        }

        try {
            BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(image.getImageBytes()));
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            if (JpegTool.needFixJPEG(image.getImageBytes())) {
                JpegTool.fixBadJPEG(originalImage);
            }

            BufferedImage resizeImage;
            if (originalImage.getWidth() <= size.getWidth()) {
                resizeImage = originalImage;
            } else {
                ImageSize scaleSize = reCalculateScaleSize(size, originalImage.getWidth(), originalImage.getHeight());
                resizeImage = resizeImage(originalImage, type, scaleSize);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizeImage, image.getImageType().getExt(), baos);
            baos.flush();
            byte[] imageBytes = baos.toByteArray();
            baos.close();

            ImageEntity newImage = new ImageEntity();
            newImage.setPath(image.getPath());
            newImage.setImageBytes(imageBytes);
            return newImage;
        } catch (Exception e) {
            logger.error("resize image error.", e);
        }
        return image;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int type, ImageSize size) {
        BufferedImage resizeImage = new BufferedImage(size.getWidth(), size.getHeight(), type);
        Graphics2D g = resizeImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage, 0, 0, size.getWidth(), size.getHeight(), null);
        g.dispose();
        return resizeImage;
    }

    private ImageSize reCalculateScaleSize(ImageSize size, int originWidth, int originalHeight) {
        ImageSize newSize = new ImageSize();
        double scale = originalHeight * 1.0 / originWidth;
        newSize.setWidth(size.getWidth());
        newSize.setHeight((int) Math.ceil(size.getWidth() * scale));
        return newSize;
    }
}
