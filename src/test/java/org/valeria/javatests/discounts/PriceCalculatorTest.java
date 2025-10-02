package org.valeria.javatests.discounts;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceCalculatorTest {
    @Test
    public void totalZeroWhenThereAreNoPrices() {
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(new double[]{}), is(0.0));
    }

    @Test
    public void totalIsTheSumOfPrices() {
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(new double[]{10.0, 20.0, 30.0}), is(60.0));
    }

    @Test
    public void applyDiscountToPrices() {
        PriceCalculator calculator = new PriceCalculator();
        double total = calculator.getTotal(new double[]{11.5, 25.7, 44.9});
        double discountedTotal = calculator.applyDiscount(total, 10); // 10% de descuento
        assertThat(discountedTotal, is(73.89));
    }
}