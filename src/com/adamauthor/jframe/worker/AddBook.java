package com.adamauthor.jframe.worker;

import com.adamauthor.Main;
import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;
import com.adamauthor.publications.Books;
import com.adamauthor.publications.Magazines;
import com.adamauthor.publications.Publication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

public class AddBook extends Container {
    public AddBook() {
        setSize(500, 400);
        setLayout(null);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(90, 60, 60, 30);
        add(titleLabel);

        JTextField titleText = new JTextField();
        titleText.setBounds(150, 60, 150, 30);
        add(titleText);

        JLabel authorLabel = new JLabel("Author: ");
        authorLabel.setBounds(90, 100, 60, 30);
        add(authorLabel);

        JTextField authorTextField = new JTextField();
        authorTextField.setBounds(150, 100, 150, 30);
        add(authorTextField);

        JLabel genreLabel = new JLabel("Genre: ");
        genreLabel.setBounds(90, 140, 60, 30);
        add(genreLabel);

        JTextField genreTextField = new JTextField();
        genreTextField.setBounds(150, 140, 150, 30);
        add(genreTextField);

        JLabel yearLabel = new JLabel("Year: ");
        yearLabel.setBounds(90, 140, 60, 30);
        add(yearLabel);

        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(150, 140, 150, 30);
        add(yearTextField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(90, 180, 210, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Books bookAdd = new Books(titleLabel.getText(), authorLabel.getText(), genreLabel.getText(), Integer.parseInt(yearLabel.getText()));
                Main.book.add(bookAdd);
                Main.publication.add(bookAdd);

                try {
                    BufferedWriter appendWriter = new BufferedWriter(new FileWriter("books.txt", true));
                    Publication lastpub = Main.publication.get(Main.publication.size() - 1);
                    String pubS = lastpub.publicationInfo() + "\n";

                    appendWriter.write(pubS);
                    appendWriter.close();

                } catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        add(addButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(90, 220, 210, 30);
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
