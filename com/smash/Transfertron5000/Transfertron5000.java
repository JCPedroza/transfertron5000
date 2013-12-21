package com.smash.Transfertron5000;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.smash.Transfertron5000.listeners.CheckListener;
import com.smash.Transfertron5000.listeners.ScanListener;

public class Transfertron5000 {
    
    private int textPaneWidth    = 200;
    private int textPaneHeigth   = 200;
    private int scrollPaneWidth  = 400;
    private int scrollPaneHeigth = 200;
    
    private JPanel          buttonPanel;
    private JFrame          frame;
    private JButton         scanButton;
    private JButton         checkButton;
    private JTextPanePlus   info;
    private JScrollPane     scrollPane;
        
    public static void main(String[] args) {
        
        Transfertron5000 gui = new Transfertron5000();
        gui.go();
        
    }
    
    private void go() {
        
        frame       = new JFrame("Transfertron5000");
        scanButton  = new JButton("scan");
        checkButton = new JButton("check");
        buttonPanel = new JPanel();
        info        = new JTextPanePlus();
        scrollPane  = new JScrollPane( info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        
        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set buttonPanel properties
        buttonPanel.setLayout(new FlowLayout());
        
        // Set button properties
        scanButton.setSize(20, 20);
        checkButton.setSize(20, 20);
        scanButton.addActionListener(new ScanListener(info, frame));
        checkButton.addActionListener(new CheckListener(scrollPane, frame));
        
        // Set JTextPane properties
        info.setEditable(false);
        info.setSize(textPaneWidth, textPaneHeigth);
        info.setText("info :D");
        info.setFont(new Font("Courier", Font.PLAIN, 12));
        info.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        info.setMargin(new Insets(5, 5, 5, 5));
        
        // Set JScrollPane properties
        scrollPane.setPreferredSize(new Dimension(scrollPaneWidth, scrollPaneHeigth));
        
        // Add components
        buttonPanel.add(scanButton);
        buttonPanel.add(checkButton);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
        
    }
}

