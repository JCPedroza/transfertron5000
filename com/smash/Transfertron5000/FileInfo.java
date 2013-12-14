package com.smash.Transfertron5000;

import java.io.Serializable;

public class FileInfo implements Serializable, Comparable<FileInfo> {
    
    private static final long serialVersionUID = 8540479341546942876L;
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
    
    // Compare methods:
    
    public boolean equalsName(FileInfo that) {
        return this.name.equals(that.getName());
    }
    
    public boolean equalsMd5(FileInfo that) {
        return this.md5.equals(that.getMd5());
    }
    
    public boolean equalsSha1(FileInfo that) {
        return this.sha1.equals(that.getSha1());
    }
    
    public boolean equals(FileInfo that) {
        return this.equalsName(that) && 
               this.equalsMd5(that)  &&
               this.equalsSha1(that);

    }
    
    @Override
    public int compareTo(FileInfo that) {
        return this.name.compareTo(that.getName());
    }

}
