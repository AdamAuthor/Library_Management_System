package com.adamauthor.jframe.reader;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;
import com.adamauthor.publications.Publication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Find extends Container {
    public Find() {
        setSize(500, 400);
        setLayout(null);

        JLabel findLabel = new JLabel("Enter the name of the publication: ");
        findLabel.setBounds(90, 100, 350, 30);
        add(findLabel);

        JTextField findText = new JTextField();
        findText.setBounds(100, 140, 300, 30);
        add(findText);

        JTextField goalText = new JTextField();
        goalText.setBounds(100, 180, 300, 30);
        goalText.setEditable(false);
        add(goalText);

        JButton findButton = new JButton("FIND");
        findButton.setBounds(100, 220, 300, 30);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = findText.getText();
                for (Publication publicFind : Main.publication) {
                    if (publicFind.getTitle().equals(title)) {
                        goalText.setText(publicFind.publicationInfo());
                    } else {
                        findText.setText("");
                    }
                }
            }
        });
        add(findButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 260, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.readerMenuWindow.setVisible(true);
                MainFrame.findWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
