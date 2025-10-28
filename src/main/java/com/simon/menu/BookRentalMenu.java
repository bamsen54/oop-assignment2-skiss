package com.simon.menu;

import static java.lang.IO.*;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;
import com.simon.rental.Rental;

public class BookRentalMenu {

    public static void bookRental( MemberRegistry memberRegistry, Inventory inventory ) {

        Integer memberID    = null;
        Integer inventoryID = null;
        Integer days        = null;

        final Member member;
        final InventoryEntry inventoryEntry;

        try {

            println( "skriv in id för medlem och id för det du ska hyra och hur länge (dygn): ");
            print( "medlem id: " );
            memberID = Integer.parseInt( readln() );
            member   = memberRegistry.getMember( memberID );
            println( member.getId() + "|" +  member.getName() + "|" + member.getLevel() );

            print( "artikel id: " );
            inventoryID = Integer.parseInt( readln() );
            inventoryEntry = inventory.getInventory().get( inventoryID );
            println( inventoryEntry );

            print( "antal dagar: " );
            days        = Integer.parseInt( readln() );


            if( memberID < 0 || inventoryID < 0 || days < 0 ) {
                println( "endast icke-negativa heltal" );
                return;
            }

            if( member == null || inventoryEntry == null )
                throw new NullPointerException();

            if( inventoryEntry.getQuantityInStore() < 1 ) {
                println( "alla av den artikeln är uthyrda\n" );
                return;
            }

            Rental rental = new Rental( member, inventoryEntry.getItem(), String.valueOf( days ) );

            println( rental + "\n" );

            member.addToCurrentRentals( rental );
            member.getRentalHistory().add( rental );

            inventoryEntry.setQuantityInStore( inventoryEntry.getQuantityInStore() - 1 );
        }

        catch ( NumberFormatException e ) {
            println( "alla invärden ska vara icke negativa heltal " );
        }

        catch ( NullPointerException e ) {
            println( "antingen finns inte någon medlem med det id:t eller finns ingen sak med det id:t i förådet\n" );
        }
    }
}
