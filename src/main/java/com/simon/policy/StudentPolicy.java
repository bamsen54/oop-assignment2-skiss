package com.simon.policy;

import com.simon.Level;

public class StudentPolicy implements PricePolicy {

    private final double changeFactor = 0.85;

    public StudentPolicy() {
    }


    @Override
    public double getPrice(int days) {
        return changeFactor * 25 * days;
    }

    @Override
    public double getEntryFee() {
        return 0;
    }
}
