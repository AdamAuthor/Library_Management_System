package com.adamauthor;

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
    private static final ArrayList<Readers> reader = new ArrayList<>();
    private static final ArrayList<Workers> worker = new ArrayList<>();
    private static final ArrayList<Books> book = new ArrayList<>();
    private static final ArrayList<Magazines> magazine = new ArrayList<>();
    private static final ArrayList<Publication> publication = new ArrayList<>();

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

        System.out.println("Welcome to the Library Management System!");
        System.out.println("Are you a reader, or do you work in our library? ");

        boolean workerTrue = false;
        boolean readerTrue = false;

        while (true) {
            System.out.println(
                    "PRESS [1] IF YOU READER\n" +
                            "PRESS [2] IF YOU WORKER"
            );

            int switchNum = in.nextInt();
            if (switchNum == 1) {
                readerTrue = true;
                break;
            } else if (switchNum == 2) {
                workerTrue = true;
                break;
            } else {
                System.out.println("Please, enter correct num");
            }
        }

        boolean readerIDEqual = false;
        boolean workerIDEqual = false;

        if (readerTrue) {
            while (true) {
                System.out.print("Reader, enter your ID: ");
                int num = in.nextInt();
                for (Readers readers : reader) {
                    if (readers.getPersonID() == num) {
                        readerIDEqual = true;
                        break;
                    }
                }

                if (readerIDEqual) {
                    break;
                } else {
                    System.out.println("Error!\n");
                }
            }
        }

        if (workerTrue) {
            while (true) {
                System.out.print("Enter your ID: ");
                int num = in.nextInt();
                for (Workers workers : worker) {
                    if (workers.getPersonID() == num) {
                        workerIDEqual = true;
                        break;
                    }
                }

                if (workerIDEqual) {
                    break;
                } else {
                    System.out.println("Error!\n");
                }
            }
        }

        if (readerIDEqual) {
            while (true) {
                System.out.println(
                        "PRESS [1] TO FIND PUBLICATION\n" +
                                "PRESS [2] TO DISPLAY ALL PUBLICATIONS\n" +
                                "PRESS [0] TO EXIT"
                );

                int numSwitchFull = in.nextInt();

                switch (numSwitchFull) {
                    case 1:
                        System.out.println("Enter the name of the publication you want to find:");
                        String title = in.next();
                        for (Publication publicFind : publication) {
                            if (publicFind.getTitle().equals(title)) {
                                System.out.println("Success!");
                                System.out.println(publicFind.publicationInfo());
                            }
                        }
                        break;

                    case 2:
                        for (Publication publicInfo : publication) {
                            System.out.println(publicInfo.publicationInfo());
                        }
                        System.out.println("\n");
                        break;

                    case 0:
                        System.out.println("Thank you for choosing our Library!");
                        return;

                    default:
                        System.out.println("Incorrect number\n");
                }
            }
        }

        if (workerIDEqual) {
            while (true) {
                System.out.println(
                        "PRESS [1] TO ADD PUBLICATION\n" +
                                "PRESS [2] TO DELETE PUBLICATION\n" +
                                "PRESS [3] TO DISPLAY ALL PUBLICATIONS\n" +
                                "PRESS [4] TO ADD READER\n" +
                                "PRESS [5] TO DELETE READER\n" +
                                "PRESS [6] TO DISPLAY ALL READERS\n" +
                                "PRESS [0] TO EXIT"
                );

                int numSwitchFull = in.nextInt();

                switch (numSwitchFull) {
                    case 1 -> {
                        System.out.println("What do you want to add?");
                        while (true) {
                            System.out.println(
                                    "PRESS [1] TO ADD BOOK\n" +
                                            "PRESS [2] TO ADD MAGAZINE"
                            );

                            int booOrMag = in.nextInt();

                            if (booOrMag == 1) {
                                System.out.print("Title: ");
                                String title = in.next();
                                System.out.print("Author: ");
                                String author = in.next();
                                System.out.print("Genre: ");
                                String genre = in.next();
                                System.out.print("Year of publication: ");
                                int yearOfPublication = in.nextInt();

                                Books bookAdd = new Books(title, author, genre, yearOfPublication);
                                book.add(bookAdd);
                                publication.add(bookAdd);

                                try {
                                    BufferedWriter appendWriter = new BufferedWriter(new FileWriter("books.txt", true));
                                    Publication lastpub = publication.get(publication.size() - 1);
                                    String pubS = lastpub.publicationInfo() + "\n";

                                    appendWriter.write(pubS);
                                    appendWriter.close();

                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            } else if (booOrMag == 2) {
                                System.out.print("Name of Magazine: ");
                                String name = in.next();
                                System.out.print("Title: ");
                                String title = in.next();
                                System.out.print("Publication number: ");
                                String publicationNum = in.next();
                                System.out.print("Year of publication: ");
                                int yearOfPublication = in.nextInt();

                                Magazines magazineAdd = new Magazines(name, title, publicationNum, yearOfPublication);

                                magazine.add(magazineAdd);
                                publication.add(magazineAdd);

                                try {
                                    BufferedWriter appendWriter = new BufferedWriter(new FileWriter("magazines.txt", true));
                                    Publication lastpub = publication.get(publication.size() - 1);
                                    String pubS = lastpub.publicationInfo() + "\n";

                                    appendWriter.write(pubS);
                                    appendWriter.close();

                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            } else {
                                System.out.println("Incorrect number\n");
                            }

                        }
                    }
                    case 2 -> {
                        System.out.println("Enter the name of the publication you want to delete:");
                        String title = in.next();
                        for (int i = 0; i < publication.size(); i++) {
                            Publication publicationDel = publication.get(i);
                            if (publicationDel.getTitle().equals(title)) {

                                if (publication.get(i) instanceof Books) {
                                    for (int j = 0; j < book.size(); j++) {
                                        Books bookDel = book.get(j);
                                        if (bookDel.getTitle().equals(title)) {
                                            book.remove(j);
                                            try {
                                                BufferedWriter writerBook = new BufferedWriter(new FileWriter("books.txt"));

                                                String bookS = "";

                                                for (Publication books : book) {
                                                    bookS += books.publicationInfo() + "\n";
                                                }

                                                writerBook.write(bookS);
                                                writerBook.close();

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }

                                if (publication.get(i) instanceof Magazines) {
                                    for (int j = 0; j < magazine.size(); j++) {
                                        Magazines magazineDel = magazine.get(j);
                                        if (magazineDel.getTitle().equals(title)) {
                                            magazine.remove(j);
                                            try {
                                                BufferedWriter writerMagazine = new BufferedWriter(new FileWriter("magazines.txt"));

                                                String magazineStr = "";

                                                for (Publication magazines : magazine) {
                                                    magazineStr += magazines.publicationInfo() + "\n";
                                                }

                                                writerMagazine.write(magazineStr);
                                                writerMagazine.close();

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                publication.remove(i);
                                System.out.println("Success!");
                            }
                        }
                    }
                    case 3 -> {
                        for (Publication publication : publication) {
                            System.out.println(publication.publicationInfo());
                        }
                        System.out.println("\n");
                    }
                    case 4 -> {
                        System.out.print("Person ID: ");
                        int id = in.nextInt();
                        System.out.println("Full name:");
                        String name = in.next();
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        Readers readerAdd = new Readers(id, name, year);
                        reader.add(readerAdd);

                        try {
                            BufferedWriter appendWriter = new BufferedWriter(new FileWriter("readers.txt", true));
                            Readers lastReader = reader.get(reader.size() - 1);
                            String readS = lastReader.personInfo() + "\n";

                            appendWriter.write(readS);
                            appendWriter.close();

                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    case 5 -> {
                        System.out.println("Enter the ID of the reader you want to delete:");
                        int idDel = in.nextInt();
                        for (int i = 0; i < reader.size(); i++) {
                            Readers readerDel = reader.get(i);
                            if (readerDel.getPersonID() == idDel) {
                                reader.remove(i);
                                try {
                                    BufferedWriter writerReader = new BufferedWriter(new FileWriter("readers.txt"));

                                    String readerStr = "";

                                    for (Readers readers : reader) {
                                        readerStr += readers.personInfo() + "\n";
                                    }

                                    writerReader.write(readerStr);
                                    writerReader.close();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Success!");
                            }
                        }
                    }
                    case 6 -> {
                        for (Readers readerInfo : reader) {
                            System.out.println(readerInfo.personInfo());
                        }
                        System.out.println("\n");
                    }
                    case 0 -> {
                        System.out.println("Thank you for choosing our Library!");
                        return;
                    }
                    default -> System.out.println("Incorrect number\n");
                }
            }
        }
    }
}

