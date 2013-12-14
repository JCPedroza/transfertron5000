package com.smash.Transfertron5000;

import javax.swing.*;
import java.awt.*;
import com.smash.Transfertron5000.listeners.*;

public class Transfertron5000 {

    public static void main(String[] args) {
        Transfertron5000 gui = new Transfertron5000();
        gui.go();
    }
    
    private void go() {
        JFrame  frame       = new JFrame("Transfertron5000");
        JButton scanButton  = new JButton("scan");
        JButton checkButton = new JButton("check");
        // Set frame properties
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set button properties
        scanButton.setSize(20, 20);
        checkButton.setSize(20, 20);
        scanButton.addActionListener(new ScanListener());
        // Add components
        frame.add(scanButton);
        frame.add(checkButton);
        
        frame.setVisible(true);
    }
}

