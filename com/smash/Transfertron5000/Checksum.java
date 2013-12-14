package com.smash.Transfertron5000;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

// Class that contains methods that handle checksum generation.
public class Checksum {
    
    // Generates md5 checksum hex String.
    public String generateMd5(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(new File(fileName));
        String          md5 = DigestUtils.md5Hex(fis);
        return md5;
    }
    
    public String generateSHA1(String fileName) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        int           n      = 0;
        byte[]        buffer = new byte[8192];
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        InputStream   fis    = new FileInputStream(fileName);
        while (n != -1) {
            n = fis.read(buffer);
            if (n > 0) {
                digest.update(buffer, 0, n);
            }
        }
        byte[] mdbytes = digest.digest();
        
        // Convert to hex format:
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < mdbytes.length; i++) {
            sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
}
