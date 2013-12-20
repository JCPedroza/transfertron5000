package com.smash.Transfertron5000.results;

public class ChecksumResults {
    
    private boolean[] flags;
    private String[]  names;
    private String[]  checksumsHere;
    private String[]  checksumsThere;
    private int       length;
    private String    type;
    
    public ChecksumResults(int length, String type) {
        
        this.length         = length;
        this.names          = new String[length];
        this.checksumsHere  = new String[length];
        this.checksumsThere = new String[length];
        this.flags          = new boolean[length];
        
    }
    
    // =======================================
    //               Mutators
    // =======================================
    
    /** Set information for a checksum pair. */
    public void setIndex(int index, String theName, String checksumHere, String checksumThere) {
        
        this.names[index]          = theName;
        this.checksumsHere[index]  = checksumHere;
        this.checksumsThere[index] = checksumThere;
        this.flags[index]          = checksumHere.equals(checksumThere);
        
    }

    // =======================================
    //              Accessors
    // =======================================
    
    @Override
    public String toString() {
        
        String returnString = "";
        for (int index = 0; index < this.length; index++) {
            returnString += String.format("name: %s  there: %s  here: %s \n", 
                                          this.names[index], 
                                          this.checksumsThere[index], 
                                          this.checksumsThere[index]);
        }
        returnString += "\n \n";
        return returnString;
        
    }
    
    /** Are all checksum pairs equal? */
    public Boolean isGood() {
        
        for (int index = 0; index < this.length; index++) {
            if (!flags[index]) {
                return false;
            }
        }
        return true;
        
    }
    
    public int getLength() {
        return this.length;
    }
    
    public String getType() {
        return this.type;
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
