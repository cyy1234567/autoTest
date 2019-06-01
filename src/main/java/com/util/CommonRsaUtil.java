package com.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;

public class CommonRsaUtil {
    private static final Logger logger= LoggerFactory.getLogger(CommonRsaUtil.class);
    private volatile static  String privateKey =null;
    private volatile static String publicKey =null;
    private static final Object lock = new Object();

    /**
     * 用私钥进行解密
     * @param data  公钥加密后的数据
     * @param privateKey  私钥
     * @return
     */
    public static String getSalt(String data ,String privateKey){
        String result=null;
        try{
            result = RsaUtil.decrypt(data,RsaUtil.getPrivateKey(privateKey));
        }catch (Exception e){
            logger.error("CommonRsaUtil.getSalt " ,e);
        }
        return result;
    }
    /**
     * 获取私钥
     * @return
     */
    public static String getPrivateKey(){
        if(privateKey==null){
            synchronized(lock){
                if(privateKey==null) {
                    try {
                        // 生成密钥对
                        KeyPair keyPair = RsaUtil.getKeyPair();
                        publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
                        privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
                    } catch (Exception e) {
                        logger.error("CommonRsaUtil.getPrivateKey " ,e);
                    }
                }
            }
        }
        return privateKey;
    }

    /**
     * 获取公钥
     * @return
     */
    public static String getPublicKey(){
        if(publicKey == null){
            synchronized(lock) {
                if(publicKey==null) {
                    try {
                        // 生成密钥对
                        KeyPair keyPair = RsaUtil.getKeyPair();
                        privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
                        publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
                        System.out.println("publicKey:"+publicKey);
                        System.out.println("privateKey:"+privateKey);
                    } catch (Exception e) {
                        logger.error("CommonRsaUtil.getPrivateKey " , e);
                    }
                }
            }
        }
        return publicKey;
    }

}
