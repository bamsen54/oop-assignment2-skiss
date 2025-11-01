package com.simon.policy;

import com.simon.Level;

public class StandardPolicy implements PricePolicy {

    private final double changeRate = 1.0;

    public StandardPolicy() {
    }

    @Override
    public double getPrice(int days) {
        return changeRate * 25 * days;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
