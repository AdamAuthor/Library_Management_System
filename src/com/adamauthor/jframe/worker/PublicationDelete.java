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

public class PublicationDelete extends Container {
    public PublicationDelete() {
        setSize(500, 400);
        setLayout(null);

        JLabel deleteLabel = new JLabel("Enter the name of the publication: ");
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
                String title = deleteText.getText();
                for (int i = 0; i < Main.publication.size(); i++) {
                    Publication publicationDel = Main.publication.get(i);
                    if (publicationDel.getTitle().equals(title)) {

                        if (Main.publication.get(i) instanceof Books) {
                            for (int j = 0; j < Main.book.size(); j++) {
                                Books bookDel = Main.book.get(j);
                                if (bookDel.getTitle().equals(title)) {
                                    Main.book.remove(j);
                                    try {
                                        BufferedWriter writerBook = new BufferedWriter(new FileWriter("books.txt"));

                                        String bookS = "";

                                        for (Publication books : Main.book) {
                                            bookS += books.publicationInfo() + "\n";
                                        }

                                        writerBook.write(bookS);
                                        writerBook.close();

                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                }
                            }
                        }

                        if (Main.publication.get(i) instanceof Magazines) {
                            for (int j = 0; j < Main.magazine.size(); j++) {
                                Magazines magazineDel = Main.magazine.get(j);
                                if (magazineDel.getTitle().equals(title)) {
                                    Main.magazine.remove(j);
                                    try {
                                        BufferedWriter writerMagazine = new BufferedWriter(new FileWriter("magazines.txt"));

                                        String magazineStr = "";

                                        for (Publication magazines : Main.magazine) {
                                            magazineStr += magazines.publicationInfo() + "\n";
                                        }

                                        writerMagazine.write(magazineStr);
                                        writerMagazine.close();

                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                }
                            }
                        }
                        Main.publication.remove(i);
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
