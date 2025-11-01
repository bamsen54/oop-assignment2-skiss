package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.member.Member;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;

public class AddNewMemberMenu {

    public static void addNewMember(MembershipService membershipService, IncomeService incomeService) {

        Integer id   = null;
        String name  = null;
        Level  level = null;

        try {
            println( "\nLÄGG TILL NY MEDLEM: " );

            print("id: ");
            id = Integer.parseInt( readln() );
            if( membershipService.hasMemberWithID( id ) ) {
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

        catch( NumberFormatException e ) {
            println( "id kan endast vara positiva heltal\n" );
            return;
        }

        catch ( IllegalArgumentException e ) {
            println( "medlemsnivå kan endast vara student, standard eller premium\n" );
            return;
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }

        Member newMember = new Member( id, name, level );
        membershipService.addNewMember( newMember, incomeService );
        println( newMember );
    }
}
