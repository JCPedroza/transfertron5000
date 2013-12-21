package com.smash.Transfertron5000.listeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.smash.Transfertron5000.FileInfo;
import com.smash.Transfertron5000.JTextPanePlus;
import com.smash.Transfertron5000.results.ChecksumResults;
import com.smash.Transfertron5000.results.Results;

public class CheckListener extends BaseListener implements ActionListener {
    
    private JFrame      frame;
    private JScrollPane scrollPane;
    private Results     results;
    private boolean     flag;
    
    // =======================================
    //             Constructor
    // =======================================
    
    public CheckListener(JScrollPane scrollPane, JFrame frame) {
        this.scrollPane  = scrollPane;
        this.frame       = frame;
    }
    
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
        
        int             hereLength  = here.length;
        ChecksumResults md5Results  = new ChecksumResults(hereLength, "md5"),
                        sha1Results = new ChecksumResults(hereLength, "sha1");
        Results         results     = new Results(here.length);
                
        for (int i = 0; i < here.length ; i++) {            
            md5Results.setIndex( i, here[i].getName(), here[i].getMd5(),  there[i].getMd5());
            sha1Results.setIndex(i, here[i].getName(), here[i].getSha1(), there[i].getSha1());
        }
        
        results.setChecksumResults(md5Results, sha1Results);
               
        return results;
        
    }
       
    public void actionPerformed(ActionEvent event) {
                
        Results       comparison = compare(scan(), getInfoFile());
        flag = comparison.isGood();
        String[][]    allInfo    = comparison.getAll();
        
        JTextPanePlus textPane   = new JTextPanePlus();
        
        StyledDocument doc = textPane.getStyledDocument();
        Style style        = textPane.addStyle("style", null);
        
        textPane.setFont(new Font("Courier", Font.PLAIN, 12));
                
        for (int index = 0; index < allInfo.length; index++) {
            
            boolean isOk   = Boolean.parseBoolean(allInfo[index][3]);
            String  string = "here: "  + allInfo[index][0] + "  " + 
                             "there: " + allInfo[index][1] + "  " +
                             "name: "  + allInfo[index][2] + "\n";
            
            if (isOk) {
                StyleConstants.setForeground(style, Color.BLACK);
            } else {
                StyleConstants.setForeground(style, Color.RED);
            }
            
            try {
                doc.insertString(doc.getLength(), string, style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            } 
        }
        
        scrollPane.setViewportView(textPane);
        
    }
    
}
