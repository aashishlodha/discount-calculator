package org.aashish.test.discountcalculator.service;

import org.aashish.test.discountcalculator.enums.CustomerType;
import org.aashish.test.discountcalculator.util.DiscountSlabHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountedAmountCalculator {

    private final DiscountSlabHelper discountSlabHelper;

    @Autowired
    DiscountedAmountCalculator(DiscountSlabHelper discountSlabHelper) {
        this.discountSlabHelper = discountSlabHelper;
    }

    public double getDiscountedAmount(double billAmount, CustomerType customerType) {
        double discountedAmount = billAmount - discountSlabHelper.getTotalDiscount(billAmount, customerType);
        return discountedAmount;
    }

}
