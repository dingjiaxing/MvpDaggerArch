package com.lib.http.util;

import java.net.InetAddress;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil {

    public static final String KEY = "4d3ce191b75bb02f";

    //算法名称 
    private static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式 
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return 加密后的数据
     */
    public static byte[] encrypt(String data, String key) throws Exception {

        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(key.getBytes());

        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secureKey = keyFactory.generateSecret(desKey);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, random);

        // 现在，获取数据并加密
        return cipher.doFinal(data.getBytes("utf-8"));
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return 解密后的数据
     */
    public static String decrypt(byte[] data, String key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();

        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes());

        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);

        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey secureKey = keyFactory.generateSecret(desKey);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, secureKey, random);

        // 真正开始解密操作
        return new String(cipher.doFinal(data), "utf-8");

    }

    public static void main(String[] args) throws Exception {
  /*      String source = "{\"addressId\":\"3\"}";

        String key = "4d3ce191b75bb02f";
        byte[] b = encrypt(source, key);

        String encryptData = Base64Util.encode(b);
        System.out.println("加密后: " + encryptData);


        byte[] decode = Base64Util.decode(encryptData);
        String decryptData = decrypt(decode, key);
        System.out.println("解密后: " + decryptData);*/



//        String BASE_URL_BJ = "https://bjopenapi.wtoip.com";

//        String BASE_URL_M = "https://m.wtoip.com";

        InetAddress inetAddress = InetAddress.getByName("bjopenapi.wtoip.com");
        String ip = inetAddress.getHostAddress();
        System.out.println(ip);

    }

}