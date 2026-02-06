

package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Case C: Missing input file
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file data/products.csv not found.");
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            // Always write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();

                // Skip blank line
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");

                // Skip wrong number of fields
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    // Trim fields
                    String idStr = parts[0].trim();
                    String name = parts[1].trim();
                    String priceStr = parts[2].trim();
                    String category = parts[3].trim();

                    int productId = Integer.parseInt(idStr);
                    BigDecimal price = new BigDecimal(priceStr);

                    // --- TRANSFORMATIONS ---

                    // 1. Uppercase name
                    name = name.toUpperCase();

                    String originalCategory = category;

                    // 2. Electronics discount
                    if (category.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // Round price HALF UP to 2 decimals
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // 3. Premium Electronics check
                    if (price.compareTo(new BigDecimal("500.00")) > 0
                            && originalCategory.equals("Electronics")) {
                        category = "Premium Electronics";
                    }

                    // 4. PriceRange
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // Write output row
                    writer.write(productId + "," + name + "," +
                            price.toString() + "," + category + "," + priceRange);
                    writer.newLine();

                    rowsWritten++;

                } catch (Exception e) {
                    // Skip rows that fail parsing
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem reading or writing files.");
            return;
        }

        // Run Summary
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsWritten);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}
