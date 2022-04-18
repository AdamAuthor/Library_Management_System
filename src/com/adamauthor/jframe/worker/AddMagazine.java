package com.adamauthor.jframe.worker;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.publications.Magazines;
import com.adamauthor.publications.Publication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddMagazine extends Container {
    public AddMagazine() {
        setSize(500, 400);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(90, 60, 60, 30);
        add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setBounds(150, 60, 150, 30);
        add(nameText);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(90, 100, 60, 30);
        add(titleLabel);

        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(150, 100, 150, 30);
        add(titleTextField);

        JLabel numberLabel = new JLabel("NUM: ");
        numberLabel.setBounds(90, 140, 60, 30);
        add(numberLabel);

        JTextField numberTextField = new JTextField();
        numberTextField.setBounds(150, 140, 150, 30);
        add(numberTextField);

        JLabel yearLabel = new JLabel("Year: ");
        yearLabel.setBounds(90, 180, 60, 30);
        add(yearLabel);

        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(150, 180, 150, 30);
        add(yearTextField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(90, 220, 210, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Magazines magazinesAdd = new Magazines(nameText.getText(), titleTextField.getText(), numberTextField.getText(), Integer.parseInt(yearTextField.getText()));
                Main.magazine.add(magazinesAdd);
                Main.publication.add(magazinesAdd);

                try {
                    BufferedWriter appendWriter = new BufferedWriter(new FileWriter("magazines.txt", true));
                    Publication lastpub = Main.publication.get(Main.publication.size() - 1);
                    String pubS = lastpub.publicationInfo() + "\n";

                    appendWriter.write(pubS);
                    appendWriter.close();

                } catch (Exception exception){
                    exception.printStackTrace();
                }
                nameText.setText("");
                titleTextField.setText("");
                numberTextField.setText("");
                yearTextField.setText("");
            }
        });
        add(addButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(90, 260, 210, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.publicationAddWindow.setVisible(true);
                MainFrame.addMagazineWindow.setVisible(false);
            }
        });


        add(backButton);
    }
}
