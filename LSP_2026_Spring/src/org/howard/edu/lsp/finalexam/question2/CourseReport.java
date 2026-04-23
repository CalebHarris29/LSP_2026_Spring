package org.howard.edu.lsp.finalexam.question2;

/**
 * CourseReport class that generates a report for a course.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    /**
     * Loads the course data.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Formats the report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    /**
     * Formats the report body.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Formats the report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}