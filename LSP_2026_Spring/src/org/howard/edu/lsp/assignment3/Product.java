package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product record from the input CSV file.
 * 
 * A Product object encapsulates the core product attributes
 * including product ID, name, price, and category.
 * 
 * This class is immutable once created.
 * 
 * @author Caleb Harris
 * @version 1.0
 */
public class Product {

    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;

    /**
     * Constructs a Product object.
     *
     * @param productId the product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the product ID.
     *
     * @return product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     *
     * @return product category
     */
    public String getCategory() {
        return category;
    }
}
