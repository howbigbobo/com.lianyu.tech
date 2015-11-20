package com.lianyu.tech.common.utils;

import java.awt.image.BufferedImage;

/**
* @author bowen
*/
public class VerifyCode {
    private BufferedImage image;
    private String result;

    VerifyCode(BufferedImage image, String result) {
        this.image = image;
        this.result = result;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getResult() {
        return result;
    }
}
