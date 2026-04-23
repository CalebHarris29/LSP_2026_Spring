package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to demonstrate Template Method pattern and polymorphism.
 */
public class Driver {

    public static void main(String[] args) {

        // Create a list of Report objects
        List<Report> reports = new ArrayList<>();

        // Add different report types
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        // Loop through list and generate reports
        for (Report report : reports) {
            report.generateReport();
        }
    }
}