package com.lianyu.tech.common.utils;

import com.lianyu.tech.core.util.StringUtils;

/**
 * @author bowen
 */
public class ByteUtils {

    public static String bytesToHex(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexToBytes(String hexString) {
        if (!StringUtils.hasText(hexString)) {
            return new byte[0];
        }
        String hexStringUpper = hexString.toUpperCase();
        int length = hexStringUpper.length() / 2;
        char[] hexChars = hexStringUpper.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
