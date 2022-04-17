package com.adamauthor.examples.StudentGUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menu;
    public static AddStudent addStudent;
    public static ListStudents listStudents;

 public MainFrame() {
     setSize(500, 400);
     setTitle("Students");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLayout(null);
     setResizable(false);

     menu = new MainMenu();
     menu.setLocation(0, 0);
     add(menu);

     addStudent = new AddStudent();
     addStudent.setLocation(0, 0);
     addStudent.setVisible(false);
     add(addStudent);

     listStudents = new ListStudents();
     listStudents.setLocation(0, 0);
     listStudents.setVisible(false);
     add(listStudents);
 }
}
