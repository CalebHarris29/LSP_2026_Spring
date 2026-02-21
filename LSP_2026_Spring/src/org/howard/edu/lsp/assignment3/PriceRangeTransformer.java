package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Adds a PriceRange classification based on product price.
 *
 * Low:     price <= 10.00
 * Medium:  price <= 100.00
 * High:    price <= 500.00
 * Premium: price > 500.00
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class PriceRangeTransformer {

    /**
     * Converts a Product to a TransformedProduct by computing the price range.
     *
     * @param input the product
     * @return transformed product with price range, or null if input is null
     */
    public TransformedProduct apply(Product input) {
        if (input == null) {
            return null;
        }

        BigDecimal price = input.getPrice();
        String priceRange;

        if (price == null) {
            priceRange = "Low"; // fallback (should not happen if input is valid)
        } else if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }

        return new TransformedProduct(
                input.getProductId(),
                input.getName(),
                input.getPrice(),
                input.getCategory(),
                priceRange
        );
    }
}