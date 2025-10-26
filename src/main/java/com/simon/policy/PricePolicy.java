package com.simon.policy;

public interface PricePolicy {

    public String getPolicyName();
    public double applyDiscount( double amount ); // the discount rate is up to each class that implements the interface
    public double getMonthlyFee();
}
