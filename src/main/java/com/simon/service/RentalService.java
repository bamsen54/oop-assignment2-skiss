package com.simon.service;

import com.simon.database.InventoryEntry;
import com.simon.member.HistoryEntry;
import com.simon.member.Member;
import com.simon.policy.PremiumPolicy;
import com.simon.policy.StandardPolicy;
import com.simon.policy.StudentPolicy;
import com.simon.rental.Rental;
import com.simon.Level;

import java.time.LocalDateTime;

public class RentalService {

    public void handleRental(InventoryEntry inventoryEntry, Member member, Rental rental, IncomeService incomeService ) {
        member.addToCurrentRentals( rental );
        inventoryEntry.setQuantityInStore( inventoryEntry.getQuantityInStore() - 1 );

        switch ( member.getLevel() ) {
            case Level.STUDENT  -> incomeService.addRentaleFees(  new StudentPolicy().applyDiscount(25 )   * Integer.parseInt( rental.getDuration() ) );
            case Level.STANDARD -> incomeService.addRentaleFees(  new StandardPolicy().applyDiscount(25 ) * Integer.parseInt( rental.getDuration() ) );
            case Level.PREMIUM  -> incomeService.addRentaleFees(  new PremiumPolicy().applyDiscount(25 )   * Integer.parseInt( rental.getDuration() ) );
        }
    }

    public void handleEndRental( InventoryEntry inventoryEntry, Member member, int index ) {
        inventoryEntry.setQuantityInStore(inventoryEntry.getQuantityInStore() + 1);

        LocalDateTime timeOfRental = member.getCurrentRentals().get( index ).getTimeOfRental();
        LocalDateTime timeOfReturn = LocalDateTime.now();
        member.getRentalHistory().add( new HistoryEntry( inventoryEntry.getItem(), timeOfRental, timeOfReturn ) );

        member.getCurrentRentals().remove( index );
    }
}
