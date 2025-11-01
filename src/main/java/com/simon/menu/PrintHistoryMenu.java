package com.simon.menu;

import static java.lang.IO.*;

import com.simon.member.HistoryEntry;
import com.simon.member.Member;
import com.simon.service.MembershipService;

public class PrintHistoryMenu {

    public static void printHistory(MembershipService membershipService) {

        final int id;
        print( "välj id för medlem vars historia du vill printa ut: " );

        try {
            id = Integer.parseInt(readln());

            if( id < 0 ) {
                println( "id:t måste vara ett icke-negativt heltal\n" );
                return;
            }

            final Member member = membershipService.getMemberWithID( id );

            if( member != null ) {

                println( "hyrningshistoria: " );
                for(HistoryEntry historyEntry: member.getRentalHistory() )
                    println( historyEntry);
            }

            else
                println( "medlem med det id:et finns inte" );
        }

        catch( NumberFormatException e ) {
            println( "id måste vara icke-negativt heltal" );
        }

        catch ( RuntimeException e) { println( "någonting gick fel" ); }

        println("");
    }
}
