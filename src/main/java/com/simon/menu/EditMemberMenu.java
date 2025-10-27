package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;

public class EditMemberMenu {

    public static void editMember(MemberRegistry memberRegistry) {

        final Member member;
        final String newName;
        final Level newLevel;

        println( "\nÄNDRA MEDLEM MED ID " );

        try {
            print("id: ");
            final int id = Integer.parseInt(readln());

            member = memberRegistry.getMember( id );

            if( member == null )
                throw new NullPointerException( "" );

            println( "medlemmens-information är just nu: " + member );
            print( "nytt namn: " );
            newName = readln();

            print( "ny medlemsnivå (student, standard eller premium): " );
            newLevel = Level.valueOf( readln().toUpperCase() );

            member.setName( newName );
            member.setLevel( newLevel );
            println( "ny medlems-information: " + member + "\n" );
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
    }
}
