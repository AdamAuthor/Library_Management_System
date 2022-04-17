package com.adamauthor.persons;

public class Workers {
    private int personID;
    private String name;
    private String surname;
    private String post;
    private int experience;
    private int salary;

    public Workers(int workerID, String name, String surname, String post, int experience, int salary) {
        this.personID = workerID;
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.experience = experience;
        this.salary = salary;
    }

    public Workers() {
    }


    public String personInfo() {
        return personID + " " + name + " " + surname + " " + post + " " + experience + " " + salary;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
