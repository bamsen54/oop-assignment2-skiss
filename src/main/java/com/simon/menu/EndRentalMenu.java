package com.simon.menu;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;
import com.simon.rental.Rental;
import com.simon.service.MembershipService;
import com.simon.service.RentalService;

import java.util.List;

import static java.lang.IO.*;
import static java.lang.IO.println;

public class EndRentalMenu {

    public static void endRental(RentalService rentalService, MembershipService membershipService, Inventory inventory ) {

        Integer memberID    = null;
        Integer inventoryID = null;

        final Member member;
        final InventoryEntry inventoryEntry;

        try {

            println( "skriv in id för medlem och id för det du lämna tillbaka: ");
            print( "medlem id: " );
            memberID = Integer.parseInt( readln() );
            member   = membershipService.getMemberRegistry().getMember( memberID );

            if( member == null )
                throw new NullPointerException( "det finns ingen medlem med det id:t" );

            println( member.getId() + "|" +  member.getName() + "|" + member.getLevel() );

            for( int choice = 1; choice <= member.getCurrentRentals().size(); choice++ )
                println( choice + ". " +  member.getCurrentRentals().get( choice - 1 ) );

            Integer userChoice = null;

            print( "välj hyrning at avsluta: " );
            userChoice = Integer.parseInt( readln() );

            if( userChoice < 1 || userChoice > member.getCurrentRentals().size() ) {
                println( "inte en siffra mellan som finns i menyvalen\n" );
                return;
            }

            inventoryID = member.getCurrentRentals().get( userChoice - 1 ).getItem().getId();
            inventoryEntry = inventory.getInventory().get( inventoryID );
            rentalService.handleEndRental( inventoryEntry, member,  userChoice - 1 );
        }

        catch( NumberFormatException e ) {
            println( "endast icke-negativa heltal\n" );
        }

        catch ( NullPointerException e ) {
            println( "finns ingen sådan member\n" );
        }

        catch ( RuntimeException e ) {}

        println( "" );
    }
}
