package org.valeria.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private final List<Double> prices = new ArrayList<>();

    public void addPrice(double price) {
        prices.add(price);
    }

    public double getTotal(double[] pricesArray) {
        double result = 0.0;
        for (double price : pricesArray) {
            result += price;
        }
        return result;
    }

    public double getTotal() {
        double result = 0.0;
        for (double price : prices) {
            result += price;
        }
        return result;
    }

    public double applyDiscount(double total, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }
        return Math.round((total - (total * (percentage / 100))) * 100.0) / 100.0;
    }
}
