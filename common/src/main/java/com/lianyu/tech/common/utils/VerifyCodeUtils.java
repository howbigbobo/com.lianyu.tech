package com.lianyu.tech.common.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author bowen
 */
public class VerifyCodeUtils {

    public static final int IMAGE_DEFAULT_WIDTH = 130;
    public static final int IMAGE_DEFAULT_HEIGHT = 50;
    private static final int IMAGE_DEFAULT_FONT_SIZE = 20;

    public static VerifyCode generate() {
        String code = generateVerifyCode(4);
        BufferedImage bufferedImage = generateVerifyCodeImage(code);
        return new VerifyCode(bufferedImage, code);
    }

    public static String generateVerifyCode(int verifyCodeLength) {
        StringBuilder verifyCode = new StringBuilder();
        for (int i = 0; i < verifyCodeLength; i++) {
            verifyCode.append(ThreadLocalRandom.current().nextInt(10));
        }
        return verifyCode.toString();
    }

    public static BufferedImage generateVerifyCodeImage(String verifyCode) {
        return generateVerifyCodeImage(verifyCode, IMAGE_DEFAULT_WIDTH, IMAGE_DEFAULT_HEIGHT);
    }

    public static BufferedImage generateVerifyCodeImage(String verifyCode, int imageWidth, int imageHeight) {
        int width = imageWidth;
        int height = imageHeight;
        if (imageWidth < 0) {
            width = IMAGE_DEFAULT_WIDTH;
        }
        if (imageHeight < 0) {
            height = IMAGE_DEFAULT_HEIGHT;
        }
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = image.createGraphics();
        //定义字体样式
        Font myFont = new Font("Monospaced", Font.BOLD, IMAGE_DEFAULT_FONT_SIZE);
        //设置字体
        g.setFont(myFont);
        //绘制背景
        g.setColor(new Color(200, 200, 200));
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        int hy = IMAGE_DEFAULT_HEIGHT / 2;
        int wx = 10 + ThreadLocalRandom.current().nextInt(10, IMAGE_DEFAULT_WIDTH / 4);
        for (int i = 0; i < verifyCode.length(); i++) {
            g.drawString(verifyCode.substring(i, i + 1), 16 * i + wx, 13 + ThreadLocalRandom.current().nextInt(5, hy));
        }
        g.drawRect(0, 0, width - 1, height - 1);
        for (int i = 0; i < 50; i++) {
            int x = ThreadLocalRandom.current().nextInt(width);
            int y = ThreadLocalRandom.current().nextInt(height);
            g.drawLine(x, y, x, y);
        }
        g.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3.5f, new float[]{3, 3}, 0f));

        g.drawLine(0, ThreadLocalRandom.current().nextInt(height), width, ThreadLocalRandom.current().nextInt(height));
        g.drawLine(0, ThreadLocalRandom.current().nextInt(height), width, ThreadLocalRandom.current().nextInt(height));
        g.dispose();
        return image;
    }
}
