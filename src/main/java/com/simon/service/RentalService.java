package com.simon.service;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.member.Member;
import com.simon.rental.Rental;

public class RentalService {

    public void handleRental(InventoryEntry inventoryEntry, Member member, Rental rental) {
        member.addToCurrentRentals( rental );
        member.getRentalHistory().add( rental );
        inventoryEntry.setQuantityInStore( inventoryEntry.getQuantityInStore() - 1 );

        // add to total income
    }

    public void handleEndRental( InventoryEntry inventoryEntry, Member member, int index ) {
        inventoryEntry.setQuantityInStore(inventoryEntry.getQuantityInStore() + 1);
        member.getCurrentRentals().remove( index );

        // add to history
    }
}
