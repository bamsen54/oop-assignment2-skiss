package com.simon.policy;

public class PremiumPolicy implements PricePolicy {

    private final double changeRate = 0.75;

    @Override
    public double applyDiscount(double amount) {
        return changeRate * amount;
    }

    @Override
    public double getEntryFee() {
        return 100;
    }
}
