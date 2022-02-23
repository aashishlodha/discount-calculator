package org.aashish.test.discountcalculator.service;

import org.aashish.test.discountcalculator.enums.CustomerType;
import org.aashish.test.discountcalculator.util.DiscountSlabHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountSlabHelperTest {

    @Autowired
    private DiscountSlabHelper helper;

    @Test
    public void testGetTotalDiscountForRegularCustomer() {
        double totalDiscount = helper.getTotalDiscount(5000, CustomerType.REGULAR);
        assertEquals(0d ,totalDiscount);

        totalDiscount = helper.getTotalDiscount(10000, CustomerType.REGULAR);
        assertEquals(500d ,totalDiscount);

        totalDiscount = helper.getTotalDiscount(15000, CustomerType.REGULAR);
        assertEquals(1500d ,totalDiscount);
    }

    @Test
    public void testGetTotalDiscountForPremiumCustomer() {
        double totalDiscount = helper.getTotalDiscount(4000, CustomerType.PREMIUM);
        assertEquals(400d ,totalDiscount);

        totalDiscount = helper.getTotalDiscount(8000, CustomerType.PREMIUM);
        assertEquals(1000d ,totalDiscount);

        totalDiscount = helper.getTotalDiscount(12000, CustomerType.PREMIUM);
        assertEquals(1800d ,totalDiscount);

        totalDiscount = helper.getTotalDiscount(20000, CustomerType.PREMIUM);
        assertEquals(4200d ,totalDiscount);
    }

}