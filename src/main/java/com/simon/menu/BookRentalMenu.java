package com.simon.menu;

import static java.lang.IO.*;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;
import com.simon.rental.Rental;
import com.simon.service.MembershipService;
import com.simon.service.RentalService;

public class BookRentalMenu {

    public static void bookRental(RentalService rentalService, MembershipService membershipService, Inventory inventory ) {

        Integer memberID    = null;
        Integer inventoryID = null;
        Integer days        = null;

        final Member member;
        final InventoryEntry inventoryEntry;

        try {

            println( "skriv in id för medlem och id för det du ska hyra och hur länge (dygn): ");
            print( "medlem id: " );
            memberID = Integer.parseInt( readln() );
            member   = membershipService.getMemberRegistry().getMember( memberID );

            if( member == null )
                throw new NullPointerException( "det finns ingen medlem med det id:t" );
            println( member.getId() + "|" +  member.getName() + "|" + member.getLevel() );

            print( "artikel id: " );
            inventoryID = Integer.parseInt( readln() );
            inventoryEntry = inventory.getInventory().get( inventoryID );

            if( inventoryEntry == null )
                throw new NullPointerException( "det finns ingenting i förådet med det id:t" );

            println( inventoryEntry );

            print( "antal dagar: " );
            days        = Integer.parseInt( readln() );


            if( memberID < 0 || inventoryID < 0 || days < 0 ) {
                println( "endast icke-negativa heltal" );
                return;
            }

            if( inventoryEntry.getQuantityInStore() < 1 ) {
                println( "alla av den artikeln är uthyrda\n" );
                return;
            }

            Rental rental = new Rental( member, inventoryEntry.getItem(), String.valueOf( days ) );
            println( rental + "\n" );
            rentalService.handleRental( inventoryEntry, member, rental );
        }

        catch ( NumberFormatException e ) {
            println( "alla invärden ska vara icke negativa heltal\n" );
        }

        catch ( NullPointerException e ) {
            println( e.getMessage() + "\n" );
        }
    }
}
