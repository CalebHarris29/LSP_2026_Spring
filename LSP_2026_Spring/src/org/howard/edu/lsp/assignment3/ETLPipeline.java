package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Runs the ETL pipeline:
 * reads input CSV, parses rows, applies transformations, writes output CSV,
 * and tracks summary statistics.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class ETLPipeline {

    private final ProductParser parser;
    private final List<Transformer<Product>> transformers;
    private final PriceRangeTransformer priceRangeTransformer;
    private final ProductWriter writer;

    /**
     * Constructs an ETLPipeline with default components.
     */
    public ETLPipeline() {
        this.parser = new ProductParser();
        this.transformers = new ArrayList<>();
        this.transformers.add(new UppercaseNameTransformer());
        this.transformers.add(new ElectronicsDiscountTransformer());
        this.transformers.add(new PriceRoundingTransformer());
        this.transformers.add(new PremiumElectronicsTransformer());
        this.priceRangeTransformer = new PriceRangeTransformer();
        this.writer = new ProductWriter();
    }

    /**
     * Executes the pipeline.
     *
     * @param inputPath relative path to input CSV (e.g., data/products.csv)
     * @param outputPath relative path to output CSV (e.g., data/transformed_products.csv)
     * @return ETLReport summary of the run
     */
    public ETLReport run(String inputPath, String outputPath) {

        ETLReport report = new ETLReport();
        File inputFile = new File(inputPath);

        // Case C: Missing input file (match HW2 behavior)
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file data/products.csv not found.");
            return report;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))
        ) {
            // Always write header
            writer.writeHeader(bw);

            // Skip header line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                report.incRead();

                // Keep HW2 behavior: trim then skip blank
                line = line.trim();
                if (line.isEmpty()) {
                    report.incSkipped();
                    continue;
                }

                // Parse row
                Product product = parser.parse(line);
                if (product == null) {
                    report.incSkipped();
                    continue;
                }

                // Apply transformations in the same order as HW2
                for (Transformer<Product> t : transformers) {
                    product = t.apply(product);
                }

                // Compute price range and write output row
                TransformedProduct out = priceRangeTransformer.apply(product);
                if (out == null) {
                    report.incSkipped();
                    continue;
                }

                writer.writeRow(bw, out);
                report.incWritten();
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem reading or writing files.");
            return report;
        }

        return report;
    }
}