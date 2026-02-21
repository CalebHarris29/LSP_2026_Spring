package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Applies a 10% discount to products in the "Electronics" category.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class ElectronicsDiscountTransformer implements Transformer<Product> {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.90");

    /**
     * Applies the electronics discount when applicable.
     *
     * @param input the product
     * @return product with discounted price if category is Electronics
     */
    @Override
    public Product apply(Product input) {
        if (input == null) {
            return null;
        }

        BigDecimal price = input.getPrice();
        String category = input.getCategory();

        if ("Electronics".equals(category) && price != null) {
            price = price.multiply(DISCOUNT_RATE);
        }

        return new Product(input.getProductId(), input.getName(), price, category);
    }
}