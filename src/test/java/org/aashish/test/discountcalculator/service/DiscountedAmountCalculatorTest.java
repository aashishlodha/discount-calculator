package org.aashish.test.discountcalculator.service;

import org.aashish.test.discountcalculator.enums.CustomerType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountedAmountCalculatorTest {

    @Autowired
    DiscountedAmountCalculator discountedAmountCalculator;

    @Test
    public void testgetDiscountedAmountForRegular() {
        double discountedAmount = discountedAmountCalculator.getDiscountedAmount(5000, CustomerType.REGULAR);
        assertEquals(5000, discountedAmount);

        discountedAmount = discountedAmountCalculator.getDiscountedAmount(10000, CustomerType.REGULAR);
        assertEquals(9500, discountedAmount);

        discountedAmount = discountedAmountCalculator.getDiscountedAmount(15000, CustomerType.REGULAR);
        assertEquals(13500, discountedAmount);
    }

    @Test
    public void testgetDiscountedAmountForPremium() {
        double discountedAmount = discountedAmountCalculator.getDiscountedAmount(4000, CustomerType.PREMIUM);
        assertEquals(3600, discountedAmount);

        discountedAmount = discountedAmountCalculator.getDiscountedAmount(8000, CustomerType.PREMIUM);
        assertEquals(7000, discountedAmount);

        discountedAmount = discountedAmountCalculator.getDiscountedAmount(12000, CustomerType.PREMIUM);
        assertEquals(10200, discountedAmount);

        discountedAmount = discountedAmountCalculator.getDiscountedAmount(20000, CustomerType.PREMIUM);
        assertEquals(15800, discountedAmount);
    }

}