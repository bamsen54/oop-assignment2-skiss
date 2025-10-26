package com.simon.policy;

import com.simon.policy.PricePolicy;

public class PremiumPolicy implements PricePolicy {

    private final double changeRate = 0.75;
    private final double monthlyFee = 100;

    @Override
    public String getPolicyName() {
        return "";
    }

    @Override
    public double applyDiscount(double amount) {
        return 0;
    }

    @Override
    public double getMonthlyFee() {
        return 0;
    }
}
