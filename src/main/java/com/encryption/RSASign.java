package com.encryption;

import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSASign {

    public static void main(String[] args) {
        getEncode();
    }
    public static boolean verifySign(String src) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            PrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec
                    = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            //生成签名bytes
            byte[] signBytes = signature.sign();

            X509EncodedKeySpec x509EncodedKeySpec =
                    new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            boolean isVerified = signature.verify(signBytes);

            return isVerified;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void getEncode() {
        String uumsPassword = "123123";
        String uumsPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZwXy7Vmpmd4Sj3JrKA0xgZjnOh/37H2UrT0zo+0esef1z+tvLzeix0QApPfYYN8mG2ofqR388w3uFNRFkrAuNfHEQgaMWWaekhwWyJKcIG3VzZgOkd4iXehZRLsMEhXDcD2ENMb+1OlFE62JlggqFGvihWPXG2JErGtOvspHpsQIDAQAB";

        String passwdEncode = URLEncoder.encode(RSAUtil.rsaEncrypt(uumsPassword, uumsPublicKey));
        System.out.println(passwdEncode);
    }

}
