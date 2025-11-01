package com.simon.policy;

import com.simon.Level;

public interface PricePolicy {

    double getPrice(int days);
    double getEntryFee();
}
