package com.smash.Transfertron5000.results;

public class ChecksumResults {
    
    private String[] names;
    private String[] checksumsHere;
    private String[] checksumsThere;
    private int      length;
    private String   type;
    private Boolean  isGood;
    
    public ChecksumResults(int length, String type) {
        
        this.length         = length;
        this.names          = new String[length];
        this.checksumsHere  = new String[length];
        this.checksumsThere = new String[length];
        
    }
    
    // =======================================
    //               Mutators
    // =======================================
    
    public void setIndex(int index, String theName, String checksumHere, String checksumThere) {
        
        this.names[index]          = theName;
        this.checksumsHere[index]  = checksumHere;
        this.checksumsThere[index] = checksumThere;
        
    }
    
    public void setIsGood(boolean bool) {
        this.isGood = bool;
    }
    
    // =======================================
    //              Accessors
    // =======================================
    
    public int getLength() {
        return this.length;
    }
    
    public String getType() {
        return this.type;
    }
    
    public Boolean getIsGood() {
        return this.isGood;
    }
    
    public String[] getIndex(int index) {
        
        String[] returnArray = { this.names[index], 
                                 this.checksumsHere[index], 
                                 this.checksumsThere[index] };
        return returnArray;
        
    }
    
    public String[][] getAll() {
        
        String[][] returnArray = new String[this.length][3];
        for (int index = 0; index < this.length; index++) {
            returnArray[index] = this.getIndex(index);
        }
        return returnArray;
        
    }
    
 }  
