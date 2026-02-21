package org.howard.edu.lsp.assignment3;

/**
 * Stores ETL run statistics (rows read, written, skipped).
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class ETLReport {

    private int rowsRead;
    private int rowsWritten;
    private int rowsSkipped;

    /** Increments rows read. */
    public void incRead() { rowsRead++; }

    /** Increments rows written. */
    public void incWritten() { rowsWritten++; }

    /** Increments rows skipped. */
    public void incSkipped() { rowsSkipped++; }

    /** @return rows read */
    public int getRowsRead() { return rowsRead; }

    /** @return rows written */
    public int getRowsWritten() { return rowsWritten; }

    /** @return rows skipped */
    public int getRowsSkipped() { return rowsSkipped; }
}