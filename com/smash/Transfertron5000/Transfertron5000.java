package com.smash.Transfertron5000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import com.smash.Transfertron5000.listeners.*;

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
        button.addActionListener(new ScanListener());
        button.setLabel("scan");
        // Add components
        frame.add(button);
        
        frame.setVisible(true);
    }
}

