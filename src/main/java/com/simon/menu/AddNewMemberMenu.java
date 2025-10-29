package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.member.Member;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;

public class AddNewMemberMenu {

    public static void addNewMember(MembershipService membershipService, IncomeService incomeService) {

        int id = - 1;
        String name = "";
        Level  level = null;
        Member member = new Member();

        try {
            println( "\nLÄGG TILL NY MEDLEM: " );

            print("id: ");
            id = Integer.parseInt( readln() );

            print("namn: ");
            name = readln();

            print("medlemsnivå (student, standard eller premium): ");
            level = Level.valueOf( readln().toUpperCase() );
        }

        // handles parseInt error
        catch( NumberFormatException e ) {
            println( "\nid kan endast vara positiva heltal\n" );
            return;
        }

        // handles Level.valueOf error
        catch ( IllegalArgumentException e ) {
            println( "medlemsnivå kan endast vara student, standard eller premium\n" );
            return;
        }

        catch ( RuntimeException e) {}

        final boolean legalAndAvailableID = id >= 0 && !membershipService.getMemberRegistry().hasMemberId( id );
        final boolean legalName           = !name.isEmpty();
        //final boolean legalLevel         = level != null;

        if( id < 0 )
            println( "id kan inte vara negativt" );

        if( membershipService.getMemberRegistry().hasMemberId( id ) )
            println( "medlem med det id:t finns redan\n" );

        if( !legalName )
            println( "namn måste innehålla åtminstone ett tecken" );

        if( legalAndAvailableID && legalName ) {
            member = new Member( id, name, level );
            membershipService.addNewMember( member, incomeService );

            switch ( level ) {

                case Level.PREMIUM -> incomeService.addEntryFees( 100 );
                case null -> {}
                default -> incomeService.addEntryFees( 0 );
            }

            println( "ny medlem: " + member );
        }
    }
}
