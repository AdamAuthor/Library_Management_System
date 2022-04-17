package com.adamauthor.persons;

public class Readers {
    private int personID;
    private String fullName;
    private int readTicketSince;


    public Readers(int readerID, String fullName, int readTicketSince) {
        this.personID = readerID;
        this.fullName = fullName;
        this.readTicketSince = readTicketSince;

    }

    public Readers() {
    }

    public String personInfo() {
        return personID + " " + fullName + " " + readTicketSince;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getReadTicketSince() {
        return readTicketSince;
    }

    public void setReadTicketSince(int readTicketSince) {
        this.readTicketSince = readTicketSince;
    }
}
