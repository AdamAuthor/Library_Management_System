package com.adamauthor.jframe.worker;

import com.adamauthor.jframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationAdd extends Container {
    public PublicationAdd() {
        setSize(500, 400);
        setLayout(null);

        JLabel questionLabel = new JLabel("Book || Magazine ?");
        questionLabel.setBounds(90, 100, 350, 30);
        add(questionLabel);

        JButton bookButton = new JButton("BOOK");
        bookButton.setBounds(100, 140, 300, 30);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.publicationAddWindow.setVisible(false);
                MainFrame.readerIDWindow.setVisible(true);
            }
        });
        add(bookButton);

        JButton magazineButton = new JButton("MAGAZINE");
        magazineButton.setBounds(100, 180, 300, 30);
        magazineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(false);
                MainFrame.workerIDWindow.setVisible(true);

            }
        });
        add(magazineButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 220, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.workerMenuWindow.setVisible(true);
                MainFrame.publicationAddWindow.setVisible(false);
            }
        });
    }
}
