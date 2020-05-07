import java.security.MessageDigest; 
import javax.xml.bind.DatatypeConverter;
  
/**
 * Simple MD5 hash calculator.
 * 
 * Can provide hex input as well.
 */
public class MD5 { 
    
    public static String getMd5(byte[] input) throws Exception { 
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        byte[] messageDigest = md.digest(input); 
        return DatatypeConverter.printHexBinary(messageDigest);
    } 
  
    public static void main(String args[]) throws Exception 
    { 
        String hexInput = "1420758261b317f1983c23c15261516b";
        byte[] input = DatatypeConverter.parseHexBinary(hexInput);
        System.out.println(getMd5(input));
    } 
} 
