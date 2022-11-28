package com.example.exercise_3;

public class Student {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int studentID = 0;

    public Student(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentID = this.studentID + 1;
    }
}
