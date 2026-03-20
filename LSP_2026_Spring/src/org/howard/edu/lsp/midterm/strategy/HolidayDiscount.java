package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 15 percent holiday discount.
 *
 * @author Caleb Harris
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies the holiday discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}