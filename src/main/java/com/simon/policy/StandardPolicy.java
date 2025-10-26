package com.simon.policy;

public class StandardPolicy implements PricePolicy {

    private final double changeRate = 1.0;
    private final double monthlyFee = 0;


    public StandardPolicy() {
    }

    @Override
    public String getPolicyName() {
        return "standard";
    }

    @Override
    public double applyDiscount(double amount) {
        return changeRate * amount;
    }

    @Override
    public double getMonthlyFee() {
        return this.monthlyFee;
    }
}
