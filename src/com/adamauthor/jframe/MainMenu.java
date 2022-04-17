package com.adamauthor.jframe;

import com.adamauthor.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public MainMenu(){
        setSize(500, 400);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to the Library Management System!");
        welcomeLabel.setBounds(90, 10, 350, 100);
        add(welcomeLabel);

        JLabel questionLabel = new JLabel("Are you a reader, or do you work in our library? ");
        questionLabel.setBounds(90, 100, 350, 30);
        add(questionLabel);

        JButton readerButton = new JButton("READER");
        readerButton.setBounds(100, 140, 300, 30);
        readerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(false);
                MainFrame.readerIDWindow.setVisible(true);
            }
        });
        add(readerButton);

        JButton workerButton = new JButton("WORKER");
        workerButton.setBounds(100, 180, 300, 30);
        workerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(false);
                MainFrame.workerIDWindow.setVisible(true);

            }
        });
        add(workerButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(100, 220, 300, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
