package com.adamauthor.jframe.worker;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ReaderDelete extends Container {
    public ReaderDelete() {
        setSize(500, 400);
        setLayout(null);

        JLabel deleteLabel = new JLabel("Enter the ID of the reader: ");
        deleteLabel.setBounds(90, 100, 350, 30);
        add(deleteLabel);

        JTextField deleteText = new JTextField();
        deleteText.setBounds(100, 140, 300, 30);
        add(deleteText);

        JTextField goalText = new JTextField();
        goalText.setBounds(100, 180, 300, 30);
        goalText.setEditable(false);
        add(goalText);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100, 220, 300, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(deleteText.getText());
                for (int i = 0; i < Main.reader.size(); i++) {
                    Readers readerDel = Main.reader.get(i);
                    if (readerDel.getPersonID() == id) {
                        Main.reader.remove(i);
                        try {
                            BufferedWriter writerReader = new BufferedWriter(new FileWriter("readers.txt"));

                            String readerStr = "";

                            for (Readers readers : Main.reader) {
                                readerStr += readers.personInfo() + "\n";
                            }

                            writerReader.write(readerStr);
                            writerReader.close();

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        goalText.setText("Success!");
                    }
                }
            }
        });
        add(deleteButton);

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
