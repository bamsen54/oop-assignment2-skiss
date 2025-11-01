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

        try {
            println( "\nLÄGG TILL NY MEDLEM: " );

            print("id: ");
            id = Integer.parseInt( readln() );

            if( membershipService.getMemberRegistry().hasMemberId( id ) ) {
                println( "medlem med det id:t finns redan\n" );
                return;
            }

            print("namn: ");
            name = readln();

            if( name.isEmpty() ) {
                println( "namn måste ha minst ett tecken\n" );
                return;
            }

            print("medlemsnivå (student, standard eller premium): ");
            level = Level.valueOf( readln().toUpperCase() );
        }

        // handles parseInt error
        catch( NumberFormatException e ) {
            println( "id kan endast vara positiva heltal\n" );
            return;
        }

        // handles Level.valueOf error
        catch ( IllegalArgumentException e ) {
            println( "medlemsnivå kan endast vara student, standard eller premium\n" );
            return;
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }

        // not reached if something went wrong
        Member newMember = new Member( id, name, level );
        membershipService.addNewMember( newMember, incomeService );

        println( newMember );
    }
}
