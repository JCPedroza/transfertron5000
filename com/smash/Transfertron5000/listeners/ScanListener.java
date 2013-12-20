package com.smash.Transfertron5000.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextArea;

import com.smash.Transfertron5000.FileInfo;

public class ScanListener extends BaseListener implements ActionListener {
    
    private JTextArea info;
    
    // =======================================
    //             Constructor
    // =======================================
    
    public ScanListener(JTextArea info) {
        this.info = info;
    }
    
    // =======================================
    //               Methods
    // =======================================
    
    private void writeData(FileInfo[] info) {
        
        FileOutputStream fileStream;
        try {
            fileStream = new FileOutputStream(".transfertron5000.ser");
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
        
    public void actionPerformed(ActionEvent event) {
        writeData(scan());
        this.info.setText("Directory Scanned");
    }
}
