package org.aashish.test.discountcalculator.util;

import org.aashish.test.discountcalculator.enums.CustomerType;
import org.aashish.test.discountcalculator.dto.DiscountSlab;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountSlabHelper {

    public double getTotalDiscount(double amount, CustomerType customerType) {
        double discountedAmount = 0;
        double remainingAmount = amount;
        List<DiscountSlab> slabs = getSlabs(customerType);

        for (DiscountSlab slab: slabs) {
            double slabAmt = 0;
            if (remainingAmount + slab.getLowerAmount() >= slab.getUpperAmount()) {
                slabAmt = slab.getUpperAmount() - slab.getLowerAmount();
            } else {
                slabAmt = amount - slab.getLowerAmount();
            }

            double slabDiscountAmt = getAmountByPercent(slabAmt, slab.getPercentage());
            discountedAmount += slabDiscountAmt;

            remainingAmount = remainingAmount - slabAmt;
            if (remainingAmount == 0) {
                break;
            }
        }

        return discountedAmount;
    }

    public List<DiscountSlab> getSlabs(CustomerType customerType) {
        switch (customerType) {
            case REGULAR:
                return getRegularCustomerDiscountSlabs();
            case PREMIUM:
                return getPremiumCustomerDiscountSlabs();
        }
        return new ArrayList();
    }

    public List<DiscountSlab> getPremiumCustomerDiscountSlabs() {
        List<DiscountSlab> slabs = new ArrayList();
        DiscountSlab discountSlab1 = new DiscountSlab(0, 4000, 10);
        DiscountSlab discountSlab2 = new DiscountSlab(4000, 8000, 15);
        DiscountSlab discountSlab3 = new DiscountSlab(8000, 12000, 20);
        DiscountSlab discountSlab4 = new DiscountSlab(12000, Double.MAX_VALUE, 30);
        slabs.add(discountSlab1);
        slabs.add(discountSlab2);
        slabs.add(discountSlab3);
        slabs.add(discountSlab4);
        return slabs;
    }

    public List<DiscountSlab> getRegularCustomerDiscountSlabs() {
        List<DiscountSlab> slabs = new ArrayList();
        DiscountSlab discountSlab1 = new DiscountSlab(0, 5000, 0);
        DiscountSlab discountSlab2 = new DiscountSlab(5000, 10000, 10);
        DiscountSlab discountSlab3 = new DiscountSlab(10000, Double.MAX_VALUE, 20);
        slabs.add(discountSlab1);
        slabs.add(discountSlab2);
        slabs.add(discountSlab3);
        return slabs;
    }

    public double getAmountByPercent(double amount, double percentage) {
        return (amount/100) * percentage;
    }
}
