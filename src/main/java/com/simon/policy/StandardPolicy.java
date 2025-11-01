package com.simon.policy;

public class StandardPolicy implements PricePolicy {

    private final double changeRate = 1.0;

    public StandardPolicy() {
    }
    @Override
    public double applyDiscount(double amount) {
        return changeRate * amount;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
