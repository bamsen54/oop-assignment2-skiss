package com.simon.policy;

import com.simon.Level;

public class PremiumPolicy implements PricePolicy {

    private final double changeRate = 0.75;

    @Override
    public double getPrice(int days) {

        if( days >= 7) {
            return changeRate * 25 * days - 25 * changeRate;
        }

        return changeRate * 25 * days;
    }

    @Override
    public double getEntryFee() {
        return 500;
    }
}
