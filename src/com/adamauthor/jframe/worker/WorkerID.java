package com.adamauthor.jframe.worker;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;
import com.adamauthor.persons.Workers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerID extends Container {
    public WorkerID() {
        setSize(500, 400);
        setLayout(null);

        JLabel idLabel = new JLabel("Enter your ID");
        idLabel.setBounds(90, 100, 350, 30);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setBounds(100, 140, 300, 30);
        add(idText);

        JButton goButton = new JButton("GO");
        goButton.setBounds(100, 180, 300, 30);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int workerID = Integer.parseInt(idText.getText());
                for (Workers workers : Main.worker) {
                    if (workers.getPersonID() == workerID) {
                        MainFrame.workerMenuWindow.setVisible(true);
                        MainFrame.workerIDWindow.setVisible(false);

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
                MainFrame.workerIDWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
