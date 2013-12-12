package com.smash.Transfertron5000;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

// Class that contains methods that handle checksum generation.
public class Checksum {
    
    // Generates md5 checksum hex String.
    public String generateMd5(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(new File(fileName));
        String md5 = DigestUtils.md5Hex(fis);
        return md5;
    }
    
}
