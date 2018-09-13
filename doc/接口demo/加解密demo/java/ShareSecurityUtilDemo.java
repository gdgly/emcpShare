package com.holley.emcpshare.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.holley.platform.common.security.Base64;

/**
 * 数据加解密
 */
public class ShareSecurityUtilDemo {

    // 加密
    public static String aesEncrypt(String sSrc, String sKey, String sKey2) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(sKey2.getBytes("UTF-8"));// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));

        // return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return Base64.encode(encrypted);
    }

    // 解密
    public static String aesDecrypt(String sSrc, String sKey, String sKey2) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(sKey2.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            // byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] encrypted1 = Base64.decode(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "UTF-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(aesEncrypt("348375728", "5EYAzSZrRV0MDNmu", "kZq6vDKpiwCqRefX"));

        String s = "5joGWG2zVcwTnCaL1gMTNflATzq1x8by09XfcfJtZShlM6R2NplqD/SliD+B2o4zyeWVr6t1kWG/SBRPIrLQaQ==";

        System.out.println(aesDecrypt(s, "5EYAzSZrRV0MDNmu", "kZq6vDKpiwCqRefX"));
    }
}
