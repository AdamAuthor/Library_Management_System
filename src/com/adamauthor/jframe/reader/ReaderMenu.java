package com.adamauthor.jframe.reader;

import com.adamauthor.jframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderMenu extends Container {
    public ReaderMenu() {
        setSize(500, 400);
        setLayout(null);

        JLabel chooseLabel = new JLabel("Choose one of the actions presented below:");
        chooseLabel.setBounds(90, 100, 350, 30);
        add(chooseLabel);

        JButton findButton = new JButton("FIND");
        findButton.setBounds(100, 140, 300, 30);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.findWindow.setVisible(true);
                MainFrame.readerMenuWindow.setVisible(false);
            }
        });
        add(findButton);

        JButton displayButton = new JButton("DISPLAY");
        displayButton.setBounds(100, 180, 300, 30);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.displayWindow.setVisible(true);
                MainFrame.readerMenuWindow.setVisible(false);
            }
        });
        add(displayButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 220, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(true);
                MainFrame.readerMenuWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
