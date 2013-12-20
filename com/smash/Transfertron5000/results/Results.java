package com.smash.Transfertron5000.results;

public class Results {
    
    private boolean         isGood;
    private String          reason;
    private boolean         sameNames;
    private ChecksumResults md5Results;
    private ChecksumResults sha1Results;
    private int             length;
    
    public Results(int length) {
        this.length      = length;        
    }
    
    public void setChecksumResults(ChecksumResults md5Results, ChecksumResults sha1Results) {
        this.md5Results  = md5Results;
        this.sha1Results = sha1Results;
    }
    
    public void setIsGood(Boolean bool, String reason) {
        this.isGood = bool;
        this.reason += (reason + " ");
    }
    
    @Override
    public String toString() {
        return md5Results.toString() + sha1Results.toString();
    }
    
}
