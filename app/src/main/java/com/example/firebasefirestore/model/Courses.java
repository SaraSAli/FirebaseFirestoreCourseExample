package com.example.firebasefirestore.model;

public class Courses {
    private String courseName, courseDescription, courseCode;

    public Courses() {
        // empty constructor
        // required for Firebase.
    }

    public Courses(String courseName, String courseDescription, String courseCode) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
