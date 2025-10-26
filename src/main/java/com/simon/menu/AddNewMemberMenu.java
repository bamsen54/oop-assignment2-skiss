package com.simon.menu;

import com.simon.Level;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;

import static java.lang.IO.*;

public class AddNewMemberMenu {

    int id = - 1;
    String name;
    Level  level;
    Member member = new Member();

    public void addNewMember(MemberRegistry memberRegistry) {

        try {
            println( "\nLÄGG TILL NY MEDLEM: " );

            print("id: ");
            id = Integer.parseInt( readln() );

            print("namn: ");
            name = readln();

            print("medlemsnivå (student, standard eller premium): ");
            level = Level.valueOf( IO.readln().toUpperCase() );
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

        final boolean legalAndAvailableID = id >= 0 && !memberRegistry.hasMemberId( id );
        final boolean legalName           = !name.isEmpty();
        final boolean legalLevdel         = level != null;

        if( id < 0 )
            println( "id kan inte vara negativt" );

        if( memberRegistry.hasMemberId( id ) )
            println( "medlem med id finns redan" );

        if( !legalName )
            println( "namn måste innehålla åtminstone ett tecken" );

        if( legalAndAvailableID && legalName && legalLevdel ) {
            member = new Member( id, name, level );
            memberRegistry.addMember( member );
            println( "ny medlem: " + member + "\n" );
        }
    }
}
