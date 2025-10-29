package com.simon.menu;

import com.simon.member.HistoryEntry;
import com.simon.member.Member;
import com.simon.service.MembershipService;

import static java.lang.IO.*;
import static java.lang.IO.println;

public class PrintHistoryMenu {

    public static void printHistory(MembershipService membershipService) {

        final int id;
        print( "välj id för medlem vars historia du vill printa ut: " );

        try {
            id = Integer.parseInt(readln());
            final Member member = membershipService.getMemberRegistry().getMember(id);

            if( member != null ) {

                println( "hyrningshistoria: " );
                for(HistoryEntry historyEntry: member.getRentalHistory() )
                    println( historyEntry);
            }

            else
                println( "medlem med det id:et finns inte" + "\n" );
        }

        catch( NumberFormatException e ) {
            println( "id måste vara icke-negativt heltal\n" );
        }

        catch (RuntimeException e)  {}

        println("");
    }
}
