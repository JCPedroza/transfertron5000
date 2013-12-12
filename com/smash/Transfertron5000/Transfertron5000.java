package com.smash.Transfertron5000;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

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
            System.out.println(System.getProperty("user.dir"));
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
