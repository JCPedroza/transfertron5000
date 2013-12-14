package com.smash.Transfertron5000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Transfertron5000 {

    public static void main(String[] args) {
        Transfertron5000 gui = new Transfertron5000();
        gui.go();
    }
    
    private void go() {
        JFrame frame  = new JFrame();
        Button button = new Button();
        // Set frame properties
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set button properties
        button.setSize(20, 20);
        button.addActionListener(new ButtonActionListener());
        // Add components
        frame.add(button);
        
        frame.setVisible(true);
    }
    
    class ButtonActionListener implements ActionListener {
        
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
            FileInfo[]   info   = new FileInfo[length];
           
        	for (int index = 0; index < length; index++){
        	    File   file      = matches[index];
        	    String md5Check  = checksum.generateMd5(file.getPath());
        	    String sha1Check = checksum.generateSHA1(file.getPath());
        	    info[index] = new FileInfo(file.getName(), md5Check, sha1Check);
        	    System.out.println(info[index].getName());
        	    System.out.println(info[index].getMd5());
        	    System.out.println(info[index].getSha1());
        	}
        }
    }
}

// Resources:
// http://stackoverflow.com/questions/1480398/java-reading-a-file-from-current-directory
// http://stackoverflow.com/questions/189094/how-to-scan-a-folder-in-java
// http://stackoverflow.com/questions/2534632/list-all-files-from-a-directory-recursively-with-java

// Checksums: 
// md5
// sha1

// MD5 (dummy_file.txt) = 9ed1c14b7774f9335f748a6e3faf6ed9
//                        9ed1c14b7774f9335f748a6e3faf6ed9
