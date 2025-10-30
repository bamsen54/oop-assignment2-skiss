package com.simon.menu;

import static java.lang.IO.*;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.member.Member;
import com.simon.rental.Rental;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;
import com.simon.service.RentalService;

public class BookRentalMenu {

    public static void bookRental(RentalService rentalService, MembershipService membershipService, Inventory inventory, IncomeService incomeService) {

        int memberID;
        int inventoryID;

        final Member member;
        final InventoryEntry inventoryEntry;

        try {
            println( "\nBOKA HYRNING");
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

            if( inventoryEntry.getQuantityInStore() < 1 ) {
                println( "alla av den artikeln är uthyrda\n" );
                return;
            }

            println( inventoryEntry );

            print( "antal dagar: " );
            int days = Integer.parseInt(readln());

            if( memberID < 0 || inventoryID < 0 || days < 0 ) {
                println( "endast icke-negativa heltal" );
                return;
            }
            Rental rental = new Rental( member, inventoryEntry.getItem(), String.valueOf( days ) );
            println( rental + "\n" );
            rentalService.handleRental( inventoryEntry, member, rental, incomeService );
        }

        catch ( NumberFormatException e ) {
            println( "alla invärden ska vara icke negativa heltal\n" );
        }

        catch ( NullPointerException e ) {
            println( e.getMessage() + "\n" );
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }
    }
}
