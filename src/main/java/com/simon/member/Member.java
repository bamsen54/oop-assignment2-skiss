package com.simon.member;

import java.util.ArrayList;
import java.util.List;

import com.simon.Level;
import com.simon.rental.Rental;

public class Member {

    private int id;
    private String name;
    private Level level;
    private List<Rental> currentRentals = new ArrayList<>();
    private List<Rental> rentalHistory = new ArrayList<>();

    public Member() {
    }

    public Member(int id, String name, Level level) {
        this.id            = id;
        this.name          = name;
        this.level         = level;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Rental> getCurrentRentals() {
        return currentRentals;
    }

    public List<Rental> getRentalHistory() {
        return rentalHistory;
    }

    public void addToCurrentRentals( Rental rental  ) {
        this.currentRentals.add( rental );
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "|"  ).append( this.id ).append( "|" ).append(  this.name ).
                      append( "|" ).append( this.level.toString() ).append( "|" );

        stringBuilder.append( "\nHyr just nu:\n" );
        for( final Rental rental : this.currentRentals )
            stringBuilder.append( rental );

        return stringBuilder.toString();
    }
}
