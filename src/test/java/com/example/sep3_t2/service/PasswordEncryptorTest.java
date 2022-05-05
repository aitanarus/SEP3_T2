package com.example.sep3_t2.service;

import com.example.sep3_t2.security.PasswordEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

class PasswordEncryptorTest {

    @Test
    void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        String input = "baeldung";
        SecretKey key = PasswordEncryptor.generateKey(128);
        IvParameterSpec ivParameterSpec = PasswordEncryptor.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = PasswordEncryptor.encrypt(algorithm, input, key, ivParameterSpec);
        System.out.println(cipherText);
        String plainText = PasswordEncryptor.decrypt(algorithm, cipherText, key, ivParameterSpec);
        System.out.println(plainText);
        Assertions.assertEquals(input, plainText);
    }
}