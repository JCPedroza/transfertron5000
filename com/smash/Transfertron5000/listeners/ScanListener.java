package com.smash.Transfertron5000.listeners;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import com.smash.Transfertron5000.FileInfo;
import com.smash.Transfertron5000.JTextPanePlus;

public class ScanListener extends BaseListener implements ActionListener {
    
    private JScrollPane scrollPane;
    private JFrame      frame;
    private JTextPane   info;
    
    // =======================================
    //             Constructor
    // =======================================
    
    public ScanListener(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
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
        
        // Set text
        JTextPanePlus textPane = new JTextPanePlus();
        StyledDocument doc     = textPane.getStyledDocument();
        Style          style   = textPane.addStyle("style", null);
        textPane.setFont(new Font("Courier", Font.PLAIN, 12));
        
        // Print text
        try {
            doc.insertString(doc.getLength(), "Scan done", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        } 
        scrollPane.setViewportView(textPane);
    }
}
