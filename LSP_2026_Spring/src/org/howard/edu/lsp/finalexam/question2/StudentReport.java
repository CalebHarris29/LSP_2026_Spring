package org.howard.edu.lsp.finalexam.question2;

/**
 * StudentReport class that generates a report for a student.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /**
     * Loads the student data.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Formats the report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
    }

    /**
     * Formats the report body.
     */
    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }

    /**
     * Formats the report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
    }
}