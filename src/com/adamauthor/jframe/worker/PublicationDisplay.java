package com.adamauthor.jframe.worker;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.publications.Publication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationDisplay extends Container {
    public PublicationDisplay() {
        setSize(500, 400);
        setLayout(null);

        JTextArea text = new JTextArea();
        text.setBounds(100, 50, 300, 150);
        text.setEditable(false);
        add(text);

        JButton findButton = new JButton("DISPLAY");
        findButton.setBounds(100, 220, 300, 30);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "";
                for (Publication publicInfo : Main.publication) {
                    str += publicInfo.publicationInfo() + "\n";
                }
                text.setText(str);
            }
        });
        add(findButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 260, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.workerMenuWindow.setVisible(true);
                MainFrame.publicationDisplayWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
