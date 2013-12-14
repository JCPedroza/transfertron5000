package com.smash.Transfertron5000.listeners;

import java.io.File;
import java.io.FileFilter;

import com.smash.Transfertron5000.Checksum;
import com.smash.Transfertron5000.FileInfo;

public class BaseListener {
    
    // Scans files and generates checksums.
    protected FileInfo[] scan() {
        
        Checksum   checksum = new Checksum();
        File       dir      = new File(System.getProperty("user.dir"));
        File[]     matches  = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                return !dir.isDirectory(); 
            }
        });
        int          length = matches.length;
        FileInfo[]   info  = new FileInfo[length];
       
        for (int index = 0; index < length; index++){
            File   file      = matches[index];
            String md5Check  = checksum.generateMd5(file.getPath());
            String sha1Check = checksum.generateSHA1(file.getPath());
            info[index]     = new FileInfo(file.getName(), md5Check, sha1Check);
        }
        
        return info;
    }
}
