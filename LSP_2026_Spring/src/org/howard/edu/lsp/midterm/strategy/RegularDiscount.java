package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies no discount for regular customers.
 *
 * @author Caleb Harris
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price for a regular customer.
     *
     * @param price the original price
     * @return the unchanged price
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}