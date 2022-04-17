package com.adamauthor.publications;

public class Magazines extends Books implements Publication {
    private String nameOfMag;
    private String title;
    private int publicationNum;
    private int yearOfPublication;

    public Magazines(String nameOfMag, String title, int publNum, int yearOfPublication) {
        this.nameOfMag = nameOfMag;
        this.title = title;
        this.publicationNum = publNum;
        this.yearOfPublication = yearOfPublication;
    }

    public Magazines() {
    }

    public String getNameOfMag() {
        return nameOfMag;
    }

    public void setNameOfMag(String nameOfMag) {
        this.nameOfMag = nameOfMag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationNum() {
        return publicationNum;
    }

    public void setPublicationNum(int publicationNum) {
        this.publicationNum = publicationNum;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }


    @Override
    public String publicationInfo() {
        return nameOfMag + " " + title + " " + publicationNum + " " + yearOfPublication;
    }
}
