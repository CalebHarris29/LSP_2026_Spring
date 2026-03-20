package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines the strategy interface for applying a discount.
 *
 * @author Caleb Harris
 */
public interface DiscountStrategy {

    /**
     * Applies a discount strategy to the given price.
     *
     * @param price the original price
     * @return the final discounted price
     */
    double applyDiscount(double price);
}