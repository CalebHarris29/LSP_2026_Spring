package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract Report class using the Template Method pattern.
 * Defines the fixed workflow for generating reports.
 */
public abstract class Report {

    /**
     * Template method defining the steps to generate a report.
     * This method should not be overridden.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();

        System.out.println("\n=== BODY ===");
        formatBody();

        System.out.println("\n=== FOOTER ===");
        formatFooter();

        System.out.println(); // spacing between reports
    }

    // Steps to be implemented by subclasses
    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}