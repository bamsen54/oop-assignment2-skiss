package com.simon.policy;

public class PremiumPolicy implements PricePolicy {

    private final double changeRate = 0.75;

    @Override
    public double getPrice(int days) {

        if( days >= 7) {
            return this.changeRate * 25 * days - 25 * this.changeRate;
        }

        return this.changeRate * 25 * days;
    }

    @Override
    public double getEntryFee() {
        return 500;
    }
}
