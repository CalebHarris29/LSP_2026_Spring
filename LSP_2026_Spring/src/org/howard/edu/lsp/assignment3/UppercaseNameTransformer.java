package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Transformer that uppercases the product name.
 *
 * @author Caleb Harris
 * @version 1.0
 */
public class UppercaseNameTransformer implements Transformer<Product> {

    /**
     * Returns a new Product with the name uppercased.
     *
     * @param input the product
     * @return product with uppercased name
     */
    @Override
    public Product apply(Product input) {
        if (input == null) {
            return null;
        }

        int id = input.getProductId();
        String nameUpper = input.getName() == null ? null : input.getName().toUpperCase();
        BigDecimal price = input.getPrice();
        String category = input.getCategory();

        return new Product(id, nameUpper, price, category);
    }
}