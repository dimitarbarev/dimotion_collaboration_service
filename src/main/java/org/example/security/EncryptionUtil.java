package org.example.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY;

    static {
        String key = System.getenv("ENCRYPTION_KEY");
        if (key == null || !(key.length() == 16 || key.length() == 24 || key.length() == 32)) {
            throw new IllegalStateException("ENCRYPTION_KEY must be set and 16/24/32 chars long");
        }
        KEY = key.getBytes();
    }
    public static String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, ALGORITHM));
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }
    public static String decrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY, ALGORITHM));
            byte[] decoded = Base64.getDecoder().decode(value);
            return new String(cipher.doFinal(decoded));
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }
}

