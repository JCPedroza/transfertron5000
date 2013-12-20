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
        this.md5Results  = new ChecksumResults(length, "md5");
        this.sha1Results = new ChecksumResults(length, "sha1");
        
    }
    
    public void setIsGood(Boolean bool, String reason) {
        this.isGood = bool;
        this.reason += (reason + " ");
    }
    
}
