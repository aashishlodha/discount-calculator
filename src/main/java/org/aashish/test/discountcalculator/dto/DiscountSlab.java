package org.aashish.test.discountcalculator.dto;

public class DiscountSlab {

    private double lowerAmount;
    private double upperAmount;
    private double percentage;

    public DiscountSlab(double lowerAmount, double upperAmount, double percentage) {
        this.lowerAmount = lowerAmount;
        this.upperAmount = upperAmount;
        this.percentage = percentage;
    }

    public double getLowerAmount() {
        return lowerAmount;
    }

    public void setLowerAmount(double lowerAmount) {
        this.lowerAmount = lowerAmount;
    }

    public double getUpperAmount() {
        return upperAmount;
    }

    public void setUpperAmount(double upperAmount) {
        this.upperAmount = upperAmount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
