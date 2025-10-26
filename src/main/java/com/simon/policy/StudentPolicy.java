package com.simon.policy;

public class StudentPolicy implements PricePolicy {

    private final double changeFactor = 0.85;
    private final double monthlyFee     = 0;

    public StudentPolicy() {
    }

    public double getChangeFactor() {
        return changeFactor;
    }

    @Override
    public String getPolicyName() {
        return "student";
    }

    @Override
    public double applyDiscount(double amount) {
        return this.changeFactor * amount;
    }

    @Override
    public double getMonthlyFee() {
        return this.monthlyFee;
    }
}
