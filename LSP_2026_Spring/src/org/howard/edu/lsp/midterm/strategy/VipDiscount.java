package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 20 percent discount for VIP customers.
 *
 * @author Caleb Harris
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies the VIP discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}