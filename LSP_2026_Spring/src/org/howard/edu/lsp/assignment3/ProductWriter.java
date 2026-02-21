package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Writes transformed product records to an output CSV.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class ProductWriter {

    /**
     * Writes the CSV header row.
     *
     * @param writer the writer
     * @throws IOException if writing fails
     */
    public void writeHeader(BufferedWriter writer) throws IOException {
        writer.write("ProductID,Name,Price,Category,PriceRange");
        writer.newLine();
    }

    /**
     * Writes a transformed product as a CSV row.
     *
     * @param writer the writer
     * @param product the transformed product
     * @throws IOException if writing fails
     */
    public void writeRow(BufferedWriter writer, TransformedProduct product) throws IOException {
        writer.write(product.getProductId() + "," +
                product.getName() + "," +
                product.getPrice().toString() + "," +
                product.getCategory() + "," +
                product.getPriceRange());
        writer.newLine();
    }
}