package com.adamauthor.examples.StudentGUI;

import com.adamauthor.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public MainMenu() {
        setSize(500, 400);
        setLayout(null);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(70, 100, 300, 40);
        add(addButton);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(70, 160, 300, 40);
        add(listButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(70, 220, 300, 40);
        add(exitButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addStudent.setVisible(true);
                MainFrame.menu.setVisible(false);
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.listStudents.setVisible(true);
                MainFrame.menu.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
