package com.smash.Transfertron5000.results;

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
    
}
