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
import java.util.Calendar;

public class ReaderAdd extends Container {
    public ReaderAdd() {
        setSize(500, 400);
        setLayout(null);

        JLabel idLabel = new JLabel("Reader ID: ");
        idLabel.setBounds(90, 60, 60, 30);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setBounds(150, 60, 150, 30);
        add(idText);

        JLabel fullNameLabel = new JLabel("Full name: ");
        fullNameLabel.setBounds(90, 100, 60, 30);
        add(fullNameLabel);

        JTextField fullNameText = new JTextField();
        fullNameText.setBounds(150, 60, 150, 30);
        add(fullNameText);

        JButton addButton = new JButton("ADD STUDENT");
        addButton.setBounds(90, 220, 210, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                Readers readerAdd = new Readers(Integer.parseInt(idText.getText()), fullNameText.getText(), year);
                Main.reader.add(readerAdd);

                try {
                    BufferedWriter appendWriter = new BufferedWriter(new FileWriter("readers.txt", true));
                    Readers lastReader = Main.reader.get(Main.reader.size() - 1);
                    String readS = lastReader.personInfo() + "\n";

                    appendWriter.write(readS);
                    appendWriter.close();

                } catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        add(addButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(90, 260, 210, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.workerMenuWindow.setVisible(true);
                MainFrame.readerAddWindow.setVisible(false);
            }
        });


        add(backButton);
    }
}
