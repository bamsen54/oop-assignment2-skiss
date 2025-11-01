package com.simon.policy;

public class StudentPolicy implements PricePolicy {

    private final double changeFactor = 0.85;

    public StudentPolicy() {
    }

    public double getChangeFactor() {
        return changeFactor;
    }

    @Override
    public double applyDiscount(double amount) {
        return this.changeFactor * amount;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
