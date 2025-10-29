package com.simon.policy;

public interface PricePolicy {

    String getPolicyName();
    double applyDiscount( double amount );
    double getEntryFee();
}
