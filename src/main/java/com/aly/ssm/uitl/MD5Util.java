package com.aly.ssm.uitl;

import java.security.MessageDigest;

/**
 * Created by lizhen on 2017/7/13.
 */
public class MD5Util {
    public MD5Util() {
    }

    public static String MD5(String inStr) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = inStr.getBytes("utf-8");
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < md5Bytes.length; ++i) {
                int val = md5Bytes[i] & 255;
                if (val < 16) {
                    hexValue.append("0");
                }

                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        } catch (Exception var7) {
            System.out.println(var7.toString());
            var7.printStackTrace();
            return "";
        }
    }
}
