package com.adamauthor.jframe.reader;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderID extends Container {

    public ReaderID() {
        setSize(500, 400);
        setLayout(null);

        JLabel idLabel = new JLabel("Please, enter your reader ID");
        idLabel.setBounds(90, 100, 350, 30);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setBounds(100, 140, 300, 30);
        add(idText);

        JButton goButton = new JButton("LET`S GO!");
        goButton.setBounds(100, 180, 300, 30);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int readerID = Integer.parseInt(idText.getText());
                for (Readers readers : Main.reader) {
                    if (readers.getPersonID() == readerID) {
                        MainFrame.readerIDWindow.setVisible(false);
                        MainFrame.readerMenuWindow.setVisible(true);
                    } else {
                        idText.setText("");
                    }
                }
            }
        });
        add(goButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 220, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(true);
                MainFrame.readerIDWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
