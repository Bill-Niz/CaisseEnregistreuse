/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.*;

/**
 *
 * @author kmeleon
 */
public  class Crypto {
    
    public static String HASH(String message){
         MessageDigest md;
         String out = "";
        try {
            md= MessageDigest.getInstance("SHA-512");
 
            md.update(message.getBytes());
            byte[] mb = md.digest();
            
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            System.out.println(out.length());
            System.out.println("CRYPTO: " + out);
 
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        return out;
    } 
    
}
