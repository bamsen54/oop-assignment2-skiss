package com.simon.service;

import java.time.LocalDateTime;

import com.simon.database.InventoryEntry;
import com.simon.member.HistoryEntry;
import com.simon.member.Member;
import com.simon.policy.PremiumPolicy;
import com.simon.policy.StandardPolicy;
import com.simon.policy.StudentPolicy;
import com.simon.rental.Rental;
import com.simon.Level;

public class RentalService {



    public void handleRental(InventoryEntry inventoryEntry, Member member, Rental rental, IncomeService incomeService ) {
        member.addToCurrentRentals( rental );
        inventoryEntry.setQuantityInStore( inventoryEntry.getQuantityInStore() - 1 );



    }

    public void handleEndRental( InventoryEntry inventoryEntry, Member member, int index ) {
        inventoryEntry.setQuantityInStore(inventoryEntry.getQuantityInStore() + 1);

        LocalDateTime timeOfRental = member.getCurrentRentals().get( index ).getTimeOfRental();
        LocalDateTime timeOfReturn = LocalDateTime.now();
        member.getRentalHistory().add( new HistoryEntry( inventoryEntry.getItem(), timeOfRental, timeOfReturn ) );

        member.getCurrentRentals().remove( index );
    }
}
