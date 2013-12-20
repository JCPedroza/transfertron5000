package com.smash.Transfertron5000.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.smash.Transfertron5000.FileInfo;
import com.smash.Transfertron5000.results.Results;

public class CheckListener extends BaseListener implements ActionListener {
    
    // Get info file from directory.
    private FileInfo[] getInfoFile() {
        
        FileInputStream fileStream;
        try {
           fileStream = new FileInputStream(".transfertron5000.ser");
        } catch (FileNotFoundException e) {
            fileStream = null;
            e.printStackTrace();
        }
        
        ObjectInputStream os; 
        try {
            os = new ObjectInputStream(fileStream);
        } catch (IOException e) {
            os = null;
            e.printStackTrace();
        }
        
        Object infoObject;
        try {
            infoObject = os.readObject();
        } catch (IOException e) {
            infoObject = null;
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            infoObject = null;
            e.printStackTrace();
        }
        
        FileInfo[] info = (FileInfo[]) infoObject;
        
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return info;
    }
    
    // Check for consistencies in name, md5, and sha1.
    private Results compare(FileInfo[] here, FileInfo[] there) {
        
        int     hereLength  = here.length,
                thereLength = there.length;
        Results results     = new Results(here.length);
        
        if (hereLength != thereLength) {
            results.setIsGood(false, "file number");
            return results;
        }
        
        for (int i = 0; i < here.length; i++) {
            
        }
               
        return results;
    }
       
    public void actionPerformed(ActionEvent event) {
         
        FileInfo[] infoHere  = scan(),
                   infoThere = getInfoFile();
                 
        System.out.println(compare(infoHere, infoThere));
    }
    
}
