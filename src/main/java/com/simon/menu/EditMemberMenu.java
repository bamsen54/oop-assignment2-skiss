package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.member.Member;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;

public class EditMemberMenu {

    public static void editMember(MembershipService membershipService, IncomeService incomeService) {

        final Member member;
        final String newName;
        final Level newLevel;

        println( "\nÄNDRA MEDLEM MED ID " );

        try {
            print("id: ");
            final int id = Integer.parseInt(readln());

            member = membershipService.getMemberWithID( id );

            if( member == null )
                throw new NullPointerException( "" );

            print( "medlemmens information är just nu: " + member );
            print( "nytt namn: " );
            newName = readln();

            if( newName.isEmpty() ) {
                println( "namn måste ha minst ett tecken\n" );
                return;
            }

            print( "ny medlemsnivå (student, standard eller premium): " );
            newLevel = Level.valueOf( readln().toUpperCase() );

            Level previousLevel = member.getLevel();

            member.setName( newName );
            member.setLevel( newLevel );
            println( "ny medlems-information: " + member );

            incomeService.handleEntryFeePaymen( member, previousLevel );


        }

        catch ( NullPointerException e ) {
            println( "ingen medlem med det id:t\n" );
        }

        catch ( NumberFormatException e) {
            println( "id:n är endast icke-negativa heltal\n" );
        }

        catch ( IllegalArgumentException e ) {
            println( "medlemsnivå kan endast vara student, standard eller premium\n" );
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }
    }
}
