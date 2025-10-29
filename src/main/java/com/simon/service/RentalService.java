package com.simon.service;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.member.HistoryEntry;
import com.simon.member.Member;
import com.simon.rental.Rental;

import java.time.LocalDateTime;

public class RentalService {

    public void handleRental(InventoryEntry inventoryEntry, Member member, Rental rental) {
        member.addToCurrentRentals( rental );
        inventoryEntry.setQuantityInStore( inventoryEntry.getQuantityInStore() - 1 );

        // add to total income
    }

    public void handleEndRental( InventoryEntry inventoryEntry, Member member, int index ) {
        inventoryEntry.setQuantityInStore(inventoryEntry.getQuantityInStore() + 1);

        // add item, time of rental and time of return to history then add history entry to member
        LocalDateTime timeOfRental = member.getCurrentRentals().get( index ).getTimeOfRental();
        LocalDateTime timeOfReturn = LocalDateTime.now();
        member.getRentalHistory().add( new HistoryEntry( inventoryEntry.getItem(), timeOfRental, timeOfReturn ) );

        member.getCurrentRentals().remove( index );
    }
}
