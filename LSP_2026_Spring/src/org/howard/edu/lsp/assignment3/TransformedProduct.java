package org.howard.edu.lsp.assignment3;

/**
 * Represents a transformed product that includes
 * the calculated price range.
 *
 * This class extends Product and demonstrates inheritance
 * by adding additional output-specific data.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class TransformedProduct extends Product {

    private final String priceRange;

    /**
     * Constructs a TransformedProduct object.
     *
     * @param productId the product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     * @param priceRange the calculated price range
     */
    public TransformedProduct(int productId, String name,
                              java.math.BigDecimal price,
                              String category,
                              String priceRange) {
        super(productId, name, price, category);
        this.priceRange = priceRange;
    }

    /**
     * Returns the price range classification.
     *
     * @return price range
     */
    public String getPriceRange() {
        return priceRange;
    }
}
