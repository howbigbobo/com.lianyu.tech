package com.lianyu.tech.common.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author bowen
 */
public class MathVerifyCodeUtils {

    public static final int IMAGE_DEFAULT_WIDTH = 130;
    public static final int IMAGE_DEFAULT_HEIGHT = 50;
    private static final int IMAGE_DEFAULT_FONT_SIZE = 20;

    public static VerifyCode generate() {
        return generate(IMAGE_DEFAULT_WIDTH, IMAGE_DEFAULT_HEIGHT, IMAGE_DEFAULT_FONT_SIZE);
    }

    public static VerifyCode generate(int width, int height, int fontSize) {
        VerifyCodeInfo codeInfo = generateCode();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        drawRectangle(g, width, height);
        drawText(g, codeInfo.imageTexts, width, height, fontSize);
        drawSnow(g, width, height);

        g.dispose();
        return new VerifyCode(image, codeInfo.result);
    }

    private static VerifyCodeInfo generateCode() {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        int num1 = r.nextInt(1, 100);
        int num2 = r.nextInt(1, 100);
        VerifyCodeInfo code = new VerifyCodeInfo();
        String operation = "";
        if (num1 > num2) {
            code.result = String.valueOf(num1 - num2);
            operation = "-";
        } else {
            code.result = String.valueOf(num1 + num2);
            operation = "+";
        }
        code.imageTexts[0] = String.valueOf(num1);
        code.imageTexts[1] = operation;
        code.imageTexts[2] = String.valueOf(num2);
        code.imageTexts[3] = "=";
        code.imageTexts[4] = "?";
        return code;
    }

    private static class VerifyCodeInfo {
        public String[] imageTexts = new String[5];
        public String result;
    }

    private static void drawRectangle(Graphics2D g, int width, int height) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        Color color = new Color(r.nextInt(157, 256), r.nextInt(157, 256), r.nextInt(157, 256));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }

    private static void drawText(Graphics2D g, String[] texts, int width, int height, int fontSize) {
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        g.setColor(new Color(255, 0, 0));
        FontMetrics fontMetrics = g.getFontMetrics();

        int fontHeight = fontMetrics.getHeight();
        int marginY = (height - fontHeight) / 3;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int y = fontHeight > (height - marginY) ? fontHeight : random.nextInt(fontHeight, height - marginY);

        int totalFontWidth = 0, totalChar = 0;
        for (String text : texts) {
            totalChar += text.length();
            totalFontWidth += fontMetrics.stringWidth(text);
        }
        int charWidth = totalFontWidth / totalChar;

        int startX = charWidth * random.nextInt(1, 3);

        int avgMarginX = (width - totalFontWidth - startX) / texts.length;
        avgMarginX = avgMarginX < 0 ? 0 : avgMarginX;

        for (String text : texts) {
            g.drawString(text, startX, y);
            startX += text.length() * charWidth + avgMarginX;
        }
    }

    private static void drawSnow(Graphics2D g, int width, int height) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int snowCount = random.nextInt(80, 100);
        for (int i = 0; i < snowCount; i++) {
            Color color = new Color(random.nextInt(200, 256), random.nextInt(200, 256), random.nextInt(200, 256));
            g.setColor(color);
            g.drawString(".", random.nextInt(2, width), random.nextInt(2, height));
        }
    }
}
