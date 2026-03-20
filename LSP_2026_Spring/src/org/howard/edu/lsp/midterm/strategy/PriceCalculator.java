package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates final prices using a discount strategy.
 *
 * @author Caleb Harris
 */
public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    /**
     * Sets the discount strategy to use for price calculation.
     *
     * @param discountStrategy the discount strategy
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current discount strategy.
     *
     * @param price the original price
     * @return the final calculated price
     */
    public double calculatePrice(double price) {
        return discountStrategy.applyDiscount(price);
    }
}