package core.admin.pro.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 *
 * Created by 祥龙 on 15/12/07.
 */
public class PubPriKeyGen {

    public static void main(String[] args) throws Exception {
        PrivateKey _privateKey = getPrivateKey(new File("private.key"));
        PublicKey _publicKey = getPublicKey(new File("public.key"));

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, _publicKey);
        byte[] cipherText = cipher.doFinal("1".getBytes("UTF-8"));
        String encodeRaw = Base64.encodeBase64String(cipherText);
        System.out.println("cipher:"+encodeRaw);

        cipher.init(Cipher.DECRYPT_MODE, _privateKey);
        byte[] decodeRaw = Base64.decodeBase64(encodeRaw);
        byte[] plainText = cipher.doFinal(decodeRaw);
        System.out.println("plain:"+new String(plainText));
    }

    /**
     * 第一次使用
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws InvalidKeySpecException
     */
    public static void generateKey() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(128);
        KeyPair kp = kpg.genKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        KeyFactory fact = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pub = fact.getKeySpec(publicKey,
                RSAPublicKeySpec.class);
        RSAPrivateKeySpec priv = fact.getKeySpec(privateKey,
                RSAPrivateKeySpec.class);

        saveToFile("public.key", pub.getModulus(),
                pub.getPublicExponent());
        saveToFile("private.key", priv.getModulus(),
                priv.getPrivateExponent());
    }

    public static void saveToFile(String fileName,
                           BigInteger mod, BigInteger exp) throws IOException {
        try (ObjectOutputStream oout = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oout.writeObject(mod);
            oout.writeObject(exp);
        } catch (Exception e) {
            throw new IOException("Unexpected error", e);
        }
    }

    public static PrivateKey getPrivateKey(File file)
            throws Exception {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object _mod = ois.readObject();
        Object _exp = ois.readObject();
        ois.close();

        RSAPrivateKeySpec spec =
                new RSAPrivateKeySpec((BigInteger)_mod,(BigInteger)_exp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static PublicKey getPublicKey(File file)
            throws Exception {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
        Object _mod = ois.readObject();
        Object _exp = ois.readObject();
        ois.close();

        RSAPublicKeySpec spec =
                new RSAPublicKeySpec((BigInteger)_mod,(BigInteger)_exp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
}
