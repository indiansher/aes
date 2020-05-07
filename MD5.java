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
        String hexInput = "f5dad49535d9614c74f42c4b821d9c47";
        byte[] input = DatatypeConverter.parseHexBinary(hexInput);
        System.out.println(getMd5(input));
    } 
} 
