package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Converts category from "Electronics" to "Premium Electronics"
 * if the product price is greater than 500.00.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class PremiumElectronicsTransformer implements Transformer<Product> {

    private static final BigDecimal PREMIUM_THRESHOLD = new BigDecimal("500.00");

    /**
     * Applies the Premium Electronics rule.
     *
     * @param input the product
     * @return product with updated category when applicable
     */
    @Override
    public Product apply(Product input) {
        if (input == null) {
            return null;
        }

        String category = input.getCategory();
        BigDecimal price = input.getPrice();

        if ("Electronics".equals(category) && price != null && price.compareTo(PREMIUM_THRESHOLD) > 0) {
            category = "Premium Electronics";
        }

        return new Product(input.getProductId(), input.getName(), price, category);
    }
}