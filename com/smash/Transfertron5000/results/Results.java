package com.smash.Transfertron5000.results;

import org.apache.commons.lang3.ArrayUtils;

public class Results {
    

    private ChecksumResults md5Results;
    private ChecksumResults sha1Results;
    private int             length;
    
    // =======================================
    //             Constructor
    // =======================================
    
    public Results(int length) {
        this.length = length;        
    }
    
    // =======================================
    //              Mutators
    // =======================================
    
    public void setChecksumResults(ChecksumResults md5Results, ChecksumResults sha1Results) {
        this.md5Results  = md5Results;
        this.sha1Results = sha1Results;
    }
    
    // =======================================
    //              Accessors
    // =======================================
    
    @Override
    public String toString() {
        return md5Results.toString() + sha1Results.toString();
    }
    
    public boolean isGood() {
        return this.md5Results.isGood() && this.sha1Results.isGood();
    }
    
    public int getLength() {
        return this.length;
    }
    
    public ChecksumResults getMd5Results() {
        return md5Results;
    }
    
    public ChecksumResults getSha1Results() {
        return sha1Results;
    }
    
    public ChecksumResults[] getResults() {
        
        ChecksumResults[] returnArray = { this.getMd5Results(), 
                                          this.getSha1Results() };
        return returnArray;
        
    }
    
    public String[][] getAll() {
        
        String[][] returnArray = ArrayUtils.addAll( md5Results.getAll(), 
                                                    sha1Results.getAll() );
        return returnArray;
        
    }
    
}
