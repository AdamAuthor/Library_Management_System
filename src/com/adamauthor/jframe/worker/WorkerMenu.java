package com.adamauthor.jframe.worker;

import com.adamauthor.jframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerMenu extends Container {
    public WorkerMenu() {
        setSize(500, 400);
        setLayout(null);

        JButton addButtonP = new JButton("PUBLICATION ADD");
        addButtonP.setBounds(100, 60, 300, 30);
        addButtonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.publicationAddWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(addButtonP);

        JButton deleteButtonP = new JButton("PUBLICATION DELETE");
        deleteButtonP.setBounds(100, 100, 300, 30);
        deleteButtonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.publicationDeleteWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(deleteButtonP);

        JButton displayButtonP = new JButton("PUBLICATION DISPLAY");
        displayButtonP.setBounds(100, 140, 300, 30);
        displayButtonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.publicationDisplayWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(displayButtonP);

        JButton addButtonR = new JButton("READER ADD");
        addButtonR.setBounds(100, 180, 300, 30);
        addButtonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.readerAddWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(addButtonR);

        JButton deleteButtonR = new JButton("READER DELETE");
        deleteButtonR.setBounds(100, 220, 300, 30);
        deleteButtonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.readerDeleteWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(deleteButtonR);

        JButton displayButtonR = new JButton("READER DISPLAY");
        displayButtonR.setBounds(100, 260, 300, 30);
        displayButtonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.readerDisplayWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(displayButtonR);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100, 300, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.menuWindow.setVisible(true);
                MainFrame.workerMenuWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
