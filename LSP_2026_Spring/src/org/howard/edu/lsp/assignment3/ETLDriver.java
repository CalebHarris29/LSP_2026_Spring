package org.howard.edu.lsp.assignment3;

public class ETLDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		/**
		 * Entry point for Assignment 3 ETL Pipeline.
		 *
		 * @author Caleb Harris
		 * @version 1.0
		 */
	

		    /**
		     * Runs the Assignment 3 ETL pipeline using the required relative paths.
		     *
		     * @param args command line args (unused)
		     */
		

		        String inputPath = "data/products.csv";
		        String outputPath = "data/transformed_products.csv";

		        ETLPipeline pipeline = new ETLPipeline();
		        ETLReport report = pipeline.run(inputPath, outputPath);

		        System.out.println("Rows read: " + report.getRowsRead());
		        System.out.println("Rows transformed: " + report.getRowsWritten());
		        System.out.println("Rows skipped: " + report.getRowsSkipped());
		        System.out.println("Output written to: " + outputPath);

	}

}
