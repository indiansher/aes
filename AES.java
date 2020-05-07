import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
 
/**
 * Simple AES encryption decryption methods.
 * 
 * Both Input text and key are supposed to be in hexadecimal representation.
 * Output will also be in hexadecimal form.
 */
public class AES {

    public static SecretKey toKey(String hexKey) {
        return new SecretKeySpec(DatatypeConverter.parseHexBinary(hexKey), "AES");
    }
 
    public static String encrypt(String plaintextHex, String hexKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, AES.toKey(hexKey));
        byte[] result = cipher.doFinal(DatatypeConverter.parseHexBinary(plaintextHex));
        return DatatypeConverter.printHexBinary(result);
    }
 
    public static String decrypt(String plaintextHex, String hexKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, AES.toKey(hexKey));
        byte[] result = cipher.doFinal(DatatypeConverter.parseHexBinary(plaintextHex));
        return DatatypeConverter.printHexBinary(result);
    }
    
    public static void main(String[] args) throws Exception {
        final String keyHex = "5dfeaf1d99dc89f5ea3ab2fae71bb6cb";
        final String plaintextHex = "5dfeaf1d99dc89f5ea3ab2fae71bb6cb";
        String encrypted = AES.encrypt(plaintextHex, keyHex);
        String decrypted = AES.decrypt(encrypted, keyHex);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}
