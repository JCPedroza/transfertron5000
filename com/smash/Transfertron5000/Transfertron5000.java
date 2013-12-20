package com.smash.Transfertron5000;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.smash.Transfertron5000.listeners.CheckListener;
import com.smash.Transfertron5000.listeners.ScanListener;

public class Transfertron5000 {

    public static void main(String[] args) {
        
        Transfertron5000 gui = new Transfertron5000();
        gui.go();
        
    }
    
    private void go() {
        
        JFrame     frame       = new JFrame("Transfertron5000");
        JButton    scanButton  = new JButton("scan");
        JButton    checkButton = new JButton("check");
        JTextArea  info        = new JTextArea("info");
        
        // Set frame properties
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set button properties
        scanButton.setSize(20, 20);
        checkButton.setSize(20, 20);
        scanButton.addActionListener(new ScanListener(info));
        checkButton.addActionListener(new CheckListener(info));
        // Set JLabel properties
        info.setSize(100, 100);
        info.setText("info :D");
        // Add components
        frame.add(scanButton);
        frame.add(checkButton);
        frame.add(info);
        
        frame.setVisible(true);
        
    }
}

