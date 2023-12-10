/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.resultcalc;

/**
 *
 * @author Amazon KDP
 */

   import java.util.Scanner;

class Course {
    private String courseName;
    private String courseCode;
    private int courseUnit;
    private int courseScore;

    public Course(String courseName, String courseCode, int courseUnit, int courseScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public int calculateGradePoint() {
        if (courseScore >= 70 && courseScore <= 100) return 5;
        else if (courseScore >= 60 && courseScore <= 69) return 4;
        else if (courseScore >= 50 && courseScore <= 59) return 3;
        else if (courseScore >= 45 && courseScore <= 49) return 2;
        else if (courseScore >= 40 && courseScore <= 44) return 1;
        else return 0; // Fail
    }

    public String calculateGrade() {
        if (courseScore >= 70 && courseScore <= 100) return "A";
        else if (courseScore >= 60 && courseScore <= 69) return "B";
        else if (courseScore >= 50 && courseScore <= 59) return "C";
        else if (courseScore >= 45 && courseScore <= 49) return "D";
        else if (courseScore >= 40 && courseScore <= 44) return "E";
        else return "F"; // Fail
    }

    public int calculateGradeUnit() {
        return calculateGradePoint();
    }
}

public class ResultCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        // Prompt for the number of courses
        System.out.print("Enter the number of courses: ");
        int numberOfCourses = scanner.nextInt();

        // Array to store Course objects
        Course[] courses = new Course[numberOfCourses];

        // Input course details
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter details for Course " + (i + 1) + ":");
            scanner.nextLine(); // Consume newline
            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();
            System.out.print("Course Code: ");
            String courseCode = scanner.nextLine();
            System.out.print("Course Unit: ");
            int courseUnit = scanner.nextInt();
            System.out.print("Course Score: ");
            int courseScore = scanner.nextInt();

            // Create Course object and add to the array
            courses[i] = new Course(courseName, courseCode, courseUnit, courseScore);
        }

        // Calculate total grade points and total units
        int totalGradePoints = 0;
        int totalUnits = 0;

        for (Course course : courses) {
            totalGradePoints += course.calculateGradePoint() * course.getCourseUnit();
            totalUnits += course.getCourseUnit();
        }

        // Calculate GPA to 2 decimal places
        double gpa = (double) totalGradePoints / totalUnits;

        // Display the result in a tabular form
        System.out.println("\nResult:");
        printTableLine();
        System.out.printf("| %-34s | %-14s | %-14s | %-14s |\n", "Course Name & Code", "Course Unit", "Grade", "Grade Unit");
        printTableLine();

        for (Course course : courses) {
            System.out.printf("| %-34s | %-14d | %-14s | %-14d |\n", getCombinedNameAndCode(course.getCourseName(), course.getCourseCode()), course.getCourseUnit(),  course.calculateGrade(), course.calculateGradeUnit());
        }

        printTableLine();
        System.out.println();

        // Print GPA message
        System.out.printf("Your GPA is = %.2f\n", gpa);

        // Close the scanner
        scanner.close();
    }

    // Helper method to print horizontal lines for the table
    private static void printTableLine() {
        System.out.println("+------------------------------------+----------------+----------------+----------------+");
    }

    // Helper method to combine name and code
    private static String getCombinedNameAndCode(String name, String code) {
        return name + " " + code;
    }
}
