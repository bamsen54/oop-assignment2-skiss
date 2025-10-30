package com.simon.service;

import static java.lang.IO.println;

public class IncomeService {

    private double incomeEntryFees = 0;
    private double incomeRentalFees = 0;

    public IncomeService() {

    }

    public double getIncomeEntryFees() {
        return incomeEntryFees;
    }

    public void setIncomeEntryFees(double incomeEntryFees) {
        this.incomeEntryFees = incomeEntryFees;
    }

    public double getIncomeRentalFees() {
        return incomeRentalFees;
    }

    public void setIncomeRentalFees(double incomeRentalFees) {
        this.incomeRentalFees = incomeRentalFees;
    }

    public void addEntryFees(double incomeFees) {
        this.incomeEntryFees += incomeFees;
    }

    public void addRentaleFees(double incomeFees) {
        this.incomeRentalFees += incomeFees;
    }

    public double getTotalIncome() {
        return this.incomeEntryFees + this.incomeRentalFees;
    }

    public void printIncomeSummary() {

        println( "intäkter: " );
        println( "inträdesavgifter: " + this.incomeEntryFees );
        println( "hyrningsavgifter: " + this.incomeRentalFees );
        println( "total inkomst: " + ( this.incomeEntryFees + this.incomeRentalFees ) );
        println("");
    }
}
