package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern price calculator.
 *
 * @author Caleb Harris
 */
public class Driver {

    /**
     * Runs the driver program for different customer discount strategies.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        calculator.setDiscountStrategy(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new VipDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}