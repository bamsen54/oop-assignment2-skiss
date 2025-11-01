package com.simon.policy;

public class StandardPolicy implements PricePolicy {

    private final double changeRate = 1.0;

    public StandardPolicy() {
    }

    @Override
    public double getPrice(int days) {
        return this.changeRate * 25 * days;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
