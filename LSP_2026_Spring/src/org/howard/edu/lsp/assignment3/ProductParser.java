package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Responsible for parsing a CSV line into a Product object.
 * 
 * Handles validation and conversion of raw input data.
 * If parsing fails, null is returned.
 * 
 * @author Caleb Harris
 * @version 1.0
 */
public class ProductParser {

    /**
     * Parses a line of CSV input into a Product object.
     *
     * @param line a line from the CSV file
     * @return Product if valid, null if invalid
     */
    public Product parse(String line) {

        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split(",");

        // Expect exactly 4 fields
        if (parts.length != 4) {
            return null;
        }

        try {
            int productId = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            BigDecimal price = new BigDecimal(parts[2].trim());
            String category = parts[3].trim();

            return new Product(productId, name, price, category);

        } catch (Exception e) {
            return null; // invalid row
        }
    }
}
