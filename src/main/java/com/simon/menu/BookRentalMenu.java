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

        final Member member;
        final InventoryEntry inventoryEntry;

        try {
            member = chooseMemberByID( membershipService );
            if( member == null )
                throw new NullPointerException( "det finns ingen medlem med det id:t" );

            println( member.getId() + "|" +  member.getName() + "|" + member.getLevel() );

            inventoryEntry = chooseInventoryEntryByID( inventory );
            if( inventoryEntry == null )
                throw new NullPointerException( "det finns ingen artikel med det id:t" );

            if( inventoryEntry.getQuantityInStore() < 1  ) {
                println( "alla av den artikeln är uthyrda\n" );
                return;
            }
            println( inventoryEntry );

            print( "antal dagar: " );
            int days = Integer.parseInt( readln() );
            if( days < 1 ) {
                println( "antal dagar måste 1 eller fler\n" );
                return;
            }

            Rental rental = new Rental( member, inventoryEntry.getItem(), String.valueOf( days ) );
            println( rental + "\n" );
            rentalService.handleRental( inventoryEntry, member, rental, incomeService );
            incomeService.handleRentalFeePayment( member, days );
        }

        catch ( NullPointerException e ) {
            println( e.getMessage() + "\n");
        }

        catch ( NumberFormatException e ) {
            println( "alla invärden ska vara icke negativa heltal\n" );
        }

        catch ( RuntimeException e ) {
            println( "någonting gick fel\n" );
        }
    }

    public static Member chooseMemberByID(MembershipService membershipService) {

        println( "\nBOKA HYRNING");
        println( "skriv in id för medlem och id för det du ska hyra och hur länge (dygn): ");
        print( "medlem id: " );
        int memberID  = Integer.parseInt( readln() );
        Member member = membershipService.getMemberWithID( memberID );

        return member;
    }

    public static InventoryEntry chooseInventoryEntryByID(Inventory inventory) {

        print( "artikel id: " );
        int inventoryID = Integer.parseInt( readln() );

        return inventory.getInventory().get( inventoryID );
    }
}
