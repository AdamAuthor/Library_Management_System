package com.adamauthor.publications;

public class Books implements Publication {

    private String title;
    private String author;
    private String genre;
    private int yearOfPublication;

    public Books(String title, String author, String genre, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
    }

    public Books() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }


    @Override
    public String publicationInfo() {
        return title + " " + author + " " + genre + " " + yearOfPublication;

    }
}
