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
    
    public void actionPerformed(ActionEvent event) {
        
        FileInfo[] info = getInfoFile();
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i].getName());
            System.out.println(info[i].getSha1());
            System.out.println(info[i].getMd5());
        }
        
    }
    
}
