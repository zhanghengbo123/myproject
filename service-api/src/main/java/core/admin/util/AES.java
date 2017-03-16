package core.admin.util;

import core.admin.common.ErrorCode;
import core.admin.exception.ServiceDataException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The AES 对称加密算法
 */
public class AES {

    private static final String KEY_ALGORITHM = "AES";
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final String KEY_MD5 = "MD5";
    private static final String SALT = "DRAMABASE_%$#@!__---=+++_123@";
    private static final String SALT_USER_WEB_PUBLISH = "UserWebPublish_@#$&&_%^+DB";

    // token
    public static String encrypt(String data) {
        return encrypt(data, SALT);
    }

    public static String decrypt(String data) {
        return decrypt(data, SALT);
    }

    // user web publish
    public static String encryptUWP(String data) {
        return encrypt(data, SALT_USER_WEB_PUBLISH);
    }

    public static String decryptUWP(String data) {
        return decrypt(data, SALT_USER_WEB_PUBLISH);
    }

    public static String encrypt(String data,String salt) {
        try {
            Key key = generateKey(salt);
            Cipher c = Cipher.getInstance(KEY_ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedByte = c.doFinal(data.getBytes(CHARSET_UTF8));
            Base64 base64 = new Base64();
            return base64.encodeToString(encryptedByte);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
                | InvalidKeyException | UnsupportedEncodingException | BadPaddingException e) {
            throw new ServiceDataException(ErrorCode.SERVICE_ERROR);
        }
    }

    public static String decrypt(String data,String salt) {
        Base64 base64 = new Base64();
        try {
            byte[] encryptedTextByte = base64.decode(data.getBytes(CHARSET_UTF8));
            Key key = generateKey(salt);
            Cipher c = Cipher.getInstance(KEY_ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedByte = c.doFinal(encryptedTextByte);
            return new String(decryptedByte);
        } catch (UnsupportedEncodingException | IllegalBlockSizeException | InvalidKeyException
                | NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException e) {
            throw new ServiceDataException(ErrorCode.SERVICE_ERROR);
        }
    }

    private static Key generateKey(String secretKey) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(secretKey.getBytes(CHARSET_UTF8));
            byte[] var1 = md5.digest();
            return new SecretKeySpec(var1, KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ServiceDataException(ErrorCode.SERVICE_ERROR);
        }
    }

    public static void main(String[] args) throws Exception {
        String context = "10";
        String enc = AES.encrypt(context);
        System.out.println(enc);
        String dec = decrypt(enc);
        System.out.println(dec);

        System.out.println(decryptUWP("n21RRptdzzN8nWOlkho5K4FOxzInbpfLtMyhjbNO+s0="));
    }
}
