package com.smash.Transfertron5000.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.smash.Transfertron5000.FileInfo;

public class CheckListener extends BaseListener implements ActionListener {
    
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
    
    public boolean compare(FileInfo[] here, FileInfo[] there) {
        
        int hereLength  = here.length,
            thereLength = there.length;
        
        if (hereLength != thereLength) {
            System.out.println("hereLength:" + hereLength + " thereLength:" + thereLength);
            return false;
        }
        
        for (int i = 0; i < here.length; i++) {
            if (!here[i].equals(there[i])) {
                System.out.println(here[i].getName() + " " + there[i].getName());
                System.out.println(here[i].getMd5() + " " + there[i].getMd5());
                System.out.println(here[i].getSha1() + " " + there[i].getSha1());
                return false;
            }
        }
        
        System.out.println();
        System.out.println("here: ");
        for (FileInfo i : here) {
            System.out.println(i.getName());
        }
        System.out.println();
        System.out.println("there: ");
        for (FileInfo i : here) {
            System.out.println(i.getName());
        }
        System.out.println();
        
        return true;
    }
    
    public void actionPerformed(ActionEvent event) {
         
        FileInfo[] infoHere  = scan(),
                   infoThere = getInfoFile();
                 
        System.out.println(compare(infoHere, infoThere));
    }
    
}
