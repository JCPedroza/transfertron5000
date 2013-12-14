package com.smash.Transfertron5000;

public class FileInfo {
    
    private String name, md5, sha1;
    
    public FileInfo(String name, String md5, String sha1) {
        this.name = name;
        this.md5  = md5;
        this.sha1 = sha1;
    }
    
    // Accessors:
    public String getName() {
        return this.name;
    }
    
    public String getMd5() {
        return this.md5;
    }
    
    public String getSha1() {
        return this.sha1;
    }

}
