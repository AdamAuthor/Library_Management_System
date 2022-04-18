package com.adamauthor;

import com.adamauthor.jframe.MainFrame;
import com.adamauthor.persons.Readers;
import com.adamauthor.persons.Workers;
import com.adamauthor.publications.Books;
import com.adamauthor.publications.Magazines;
import com.adamauthor.publications.Publication;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
    public static final ArrayList<Readers> reader = new ArrayList<>();
    public static final ArrayList<Workers> worker = new ArrayList<>();
    public static final ArrayList<Books> book = new ArrayList<>();
    public static final ArrayList<Magazines> magazine = new ArrayList<>();
    public static final ArrayList<Publication> publication = new ArrayList<>();

    public static MainFrame frame;

    private static final Scanner in;
    static {
        in = new Scanner(System.in);
    }

    public static void main(String[] args) {
        try {
            BufferedReader readerReader = new BufferedReader(new FileReader("readers.txt"));
            String strReader = "";
            while ((strReader = readerReader.readLine()) != null) {
                String[] splitReader = strReader.split(" ");
                reader.add(new Readers(parseInt(splitReader[0]), splitReader[1], parseInt(splitReader[2])));
            }
            readerReader.close();

            BufferedReader readerWorker= new BufferedReader(new FileReader("workers.txt"));
            String strWorker = "";
            while ((strWorker = readerWorker.readLine()) != null) {
                String[] splitWorker = strWorker.split(" ");
                worker.add(new Workers(Integer.parseInt(splitWorker[0]), splitWorker[1], splitWorker[2], splitWorker[3], Integer.parseInt(splitWorker[4]), Integer.parseInt(splitWorker[5])));
            }
            readerWorker.close();

            BufferedReader readerBook = new BufferedReader(new FileReader("books.txt"));
            String strBook = "";
            while ((strBook = readerBook.readLine()) != null) {
                String[] splitBook = strBook.split(" ");
                book.add(new Books(splitBook[0], splitBook[1], splitBook[2], Integer.parseInt(splitBook[3])));
                publication.add(new Books(splitBook[0], splitBook[1], splitBook[2], Integer.parseInt(splitBook[3])));
            }
            readerBook.close();

            BufferedReader readerMagazine = new BufferedReader(new FileReader("magazines.txt"));
            String strMagazine = "";
            while ((strMagazine = readerMagazine.readLine()) != null) {
                String[] splitMagazine = strMagazine.split(" ");
                magazine.add(new Magazines(splitMagazine[0], splitMagazine[1], splitMagazine[2], Integer.parseInt(splitMagazine[3])));
                publication.add(new Magazines(splitMagazine[0], splitMagazine[1], splitMagazine[2], Integer.parseInt(splitMagazine[3])));
            }
            readerMagazine.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new MainFrame();
        frame.setVisible(true);
    }
}

