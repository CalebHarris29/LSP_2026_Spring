package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 10 percent discount for member customers.
 *
 * @author Caleb Harris
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies the member discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}