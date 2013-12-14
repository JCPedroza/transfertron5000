package com.smash.Transfertron5000.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.smash.Transfertron5000.Checksum;
import com.smash.Transfertron5000.FileInfo;

public class ScanListener implements ActionListener{
    public void actionPerformed(ActionEvent event) {
        
        Checksum   checksum = new Checksum();
        File       dir      = new File(System.getProperty("user.dir"));
        File[]     matches  = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                return !dir.isDirectory(); 
            }
        });
        int          length = matches.length;
        FileInfo[]   info  = new FileInfo[length];
       
        for (int index = 0; index < length; index++){
            File   file      = matches[index];
            String md5Check  = checksum.generateMd5(file.getPath());
            String sha1Check = checksum.generateSHA1(file.getPath());
            info[index]     = new FileInfo(file.getName(), md5Check, sha1Check);
        }
        
        // Writing the data to a file
        FileOutputStream fileStream;
        try {
            fileStream = new FileOutputStream(".state.ser");
        } catch (FileNotFoundException e) {
            fileStream = null;
            e.printStackTrace();
        }
        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(fileStream);
            os.writeObject(info);
            os.close();
        } catch (IOException e) {
            os = null;
            e.printStackTrace();
        }
    }
}
