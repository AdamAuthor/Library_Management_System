package com.adamauthor.jframe;

import com.adamauthor.jframe.reader.Display;
import com.adamauthor.jframe.reader.Find;
import com.adamauthor.jframe.reader.ReaderID;
import com.adamauthor.jframe.reader.ReaderMenu;
import com.adamauthor.jframe.worker.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menuWindow;

    public static ReaderID readerIDWindow;
    public static ReaderMenu readerMenuWindow;
    public static Find findWindow;
    public static Display displayWindow;

    public static WorkerID workerIDWindow;
    public static WorkerMenu workerMenuWindow;
    public static PublicationAdd publicationAddWindow;
    public static PublicationDelete publicationDeleteWindow;
    public static PublicationDisplay publicationDisplayWindow;
    public static ReaderAdd readerAddWindow;
    public static ReaderDelete readerDeleteWindow;
    public static ReaderDisplay readerDisplayWindow;

    public static AddBook addBookWindow;
    public static AddMagazine addMagazineWindow;

    public MainFrame(){
        setSize(500, 400);
        setTitle("Library Management System");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuWindow = new MainMenu();
        menuWindow.setLocation(0,0);
        add(menuWindow);

        readerMenuWindow = new ReaderMenu();
        readerMenuWindow.setLocation(0, 0);
        readerMenuWindow.setVisible(false);
        add(readerMenuWindow);

        readerIDWindow = new ReaderID();
        readerIDWindow.setLocation(0, 0);
        readerIDWindow.setVisible(false);
        add(readerIDWindow);

        findWindow = new Find();
        findWindow.setLocation(0, 0);
        findWindow.setVisible(false);
        add(findWindow);

        displayWindow = new Display();
        displayWindow.setLocation(0, 0);
        displayWindow.setVisible(false);
        add(displayWindow);

        workerIDWindow = new WorkerID();
        workerIDWindow.setLocation(0, 0);
        workerIDWindow.setVisible(false);
        add(workerIDWindow);

        workerMenuWindow = new WorkerMenu();
        workerMenuWindow.setLocation(0, 0);
        workerMenuWindow.setVisible(false);
        add(workerMenuWindow);

        publicationAddWindow = new PublicationAdd();
        publicationAddWindow.setLocation(0, 0);
        publicationAddWindow.setVisible(false);
        add(publicationAddWindow);

        addBookWindow = new AddBook();
        addBookWindow.setLocation(0, 0);
        addBookWindow.setVisible(false);
        add(addBookWindow);

        publicationDeleteWindow = new PublicationDelete();
        publicationDeleteWindow.setLocation(0, 0);
        publicationDeleteWindow.setVisible(false);
        add(publicationDeleteWindow);

        publicationDisplayWindow = new PublicationDisplay();
        publicationDisplayWindow.setLocation(0, 0);
        publicationDisplayWindow.setVisible(false);
        add(publicationDisplayWindow);

        readerDisplayWindow = new ReaderDisplay();
        readerDisplayWindow.setLocation(0, 0);
        readerDisplayWindow.setVisible(false);
        add(readerDisplayWindow);

        readerDeleteWindow = new ReaderDelete();
        readerDeleteWindow.setLocation(0, 0);
        readerDeleteWindow.setVisible(false);
        add(readerDeleteWindow);

        readerDisplayWindow = new ReaderDisplay();
        readerDisplayWindow.setLocation(0, 0);
        readerDisplayWindow.setVisible(false);
        add(readerDisplayWindow);
    }
}

