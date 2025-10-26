package com.simon.policy;

import java.security.Policy;

public class PremiumPolicy implements PricePolicy {
    @Override
    public String getPolicyName() {
        return "";
    }

    @Override
    public double applyDiscount(double amount) {
        return 0;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
