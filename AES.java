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
 
    public static String encrypt(byte[] input, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] result = cipher.doFinal(input);
        return DatatypeConverter.printHexBinary(result);
    }
    
    public static String decrypt(byte[] input, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] result = cipher.doFinal(input);
        return DatatypeConverter.printHexBinary(result);
    }
    
    public static void main(String[] args) throws Exception {
        String keyHex = "f5dad49535d9614c74f42c4b821d9c47";
    
        // Encryption
        String inputHex = "f5dad49535d9614c74f42c4b821d9c47";
        byte[] key = DatatypeConverter.parseHexBinary(keyHex);
        byte[] input = DatatypeConverter.parseHexBinary(inputHex);
        String encrypted = AES.encrypt(input, key);
        System.out.println(encrypted);
        
        // Decryption
        input = DatatypeConverter.parseHexBinary(encrypted);
        String decrypted = AES.decrypt(input, key);
        System.out.println(decrypted);
    }
}
