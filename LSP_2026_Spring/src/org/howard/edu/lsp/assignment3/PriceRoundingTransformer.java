package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Rounds product price to 2 decimals using HALF_UP rounding.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class PriceRoundingTransformer implements Transformer<Product> {

    /**
     * Rounds the product price to 2 decimals.
     *
     * @param input the product
     * @return product with rounded price
     */
    @Override
    public Product apply(Product input) {
        if (input == null) {
            return null;
        }

        BigDecimal price = input.getPrice();
        if (price != null) {
            price = price.setScale(2, RoundingMode.HALF_UP);
        }

        return new Product(input.getProductId(), input.getName(), price, input.getCategory());
    }
}