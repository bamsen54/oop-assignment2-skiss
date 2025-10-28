package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;
import com.simon.regex.Regex;

public class SearchMemberMenu {

    public static void searchMember(MemberRegistry memberRegistry) {

        try {
            final int choice;
            println("\nVälj söksätt: ");
            println("1. id");
            println("2. regex find namn ");
            println("3. regex match namn ");
            println("4. medlemsnivå ");
            print( "välj : ");
            choice = Integer.parseInt( readln() );

            switch (choice) {
                case 1 -> searchById( memberRegistry );
                case 2 -> searchByRegexName( memberRegistry, "find" );
                case 3 -> searchByRegexName( memberRegistry, "match" );
                case 4 -> searchByLevel( memberRegistry );
                default -> { }
            }
        }

        catch(NumberFormatException e) {
            // TODO
        }
    }

    public static void searchById(MemberRegistry memberRegistry) {

        final int id;
        print( "välj id att söka på: " );

        try {
            id = Integer.parseInt(readln());


            final Member member = memberRegistry.getMember(id);

            if( member != null )
                print( "medlem som har id = " + id + " är " + member + "\n" );

            else
                println( "medlem med det id:et finns inte" + "\n" );
        }

        catch( NumberFormatException e ) {
            println( "id måste vara icke-negativt heltal\n" );
        }
    }

    public static void  searchByRegexName(MemberRegistry memberRegistry, String regexType) {

        Regex regex = new Regex();

        try {
            String pattern;
            print("Skriv in mönster: ");
            pattern = readln();

            for ( Integer key : memberRegistry.getMembers().keySet() ) {
                final Member member = memberRegistry.getMembers().get( key );

                switch( regexType ) {
                    case "find"  ->  { if ( regex.isFound( member.getName(), pattern) ) print( member ); }
                    case "match" ->  { if ( regex.isMatch( member.getName(), pattern) ) print( member ); }
                }
            }
        }

        catch ( RuntimeException e ) {
        }

        println("");
    }

    public static void searchByLevel(MemberRegistry memberRegistry) {

        try {
            Level level;
            print("skriv in medlemsnivå (student, standard eller premium): ");
            level = Level.valueOf(readln().toUpperCase());

            for( Integer key : memberRegistry.getMembers().keySet() ) {
                if( memberRegistry.getMembers().get( key ).getLevel().equals( level ) )
                    print( memberRegistry.getMembers().get( key ) ) ;
            }
        }

        catch ( IllegalArgumentException e ) {
            println( "finns ingen sådan medlemsnivå\n" );
        }

        println("");
    }
}
