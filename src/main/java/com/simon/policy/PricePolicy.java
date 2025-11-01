package com.simon.policy;

public interface PricePolicy {

    double applyDiscount( double amount );
    double getEntryFee();
}
