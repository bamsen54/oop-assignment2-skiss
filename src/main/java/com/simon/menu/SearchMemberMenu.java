package com.simon.menu;

import static java.lang.IO.*;

import com.simon.Level;
import com.simon.member.Member;
import com.simon.regex.Regex;
import com.simon.service.MembershipService;

public class SearchMemberMenu {

    public static void searchMember(MembershipService  membershipService) {

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
                case 1  -> searchById( membershipService );
                case 2  -> searchByRegexName( membershipService, "find" );
                case 3  -> searchByRegexName( membershipService, "match" );
                case 4  -> searchByLevel( membershipService );
                default -> println( "Inte en siffra i menyn\n" );
            }
        }

        catch( NumberFormatException e ) {
            println( "input måste vara ett icke-negativt heltal\n" );
        }
    }

    public static void searchById(MembershipService membershipService) {

        final int id;
        print( "välj id att söka på: " );

        try {
            id = Integer.parseInt(readln());
            final Member member = membershipService.getMemberWithID( id );

            if( member != null )
                print( "medlem som har id = " + id + " är " + member + "\n" );

            else
                println( "medlem med det id:et finns inte" + "\n" );
        }

        catch( NumberFormatException e ) {
            println( "id måste vara icke-negativt heltal\n" );
        }

        catch (RuntimeException e)  { println( "någonting gick fel\n" ); }
    }

    public static void  searchByRegexName(MembershipService membershipService, String regexType) {

        try {
            String pattern;
            print("Skriv in mönster: ");
            pattern = readln();

            for ( int key : membershipService.getMemberRegistry().getMembers().keySet() ) {
                final Member member = membershipService.getMemberRegistry().getMembers().get( key );

                switch( regexType ) {
                    case "find"  ->  { if ( Regex.isFound( member.getName(), pattern) ) print( member ); }
                    case "match" ->  { if ( Regex.isMatch( member.getName(), pattern) ) print( member ); }
                }
            }
        }

        catch (RuntimeException e)  { println( "någonting gick fel\n" ); }

        println("");
    }

    public static void searchByLevel(MembershipService membershipService) {

        try {
            Level level;
            print("skriv in medlemsnivå (student, standard eller premium): ");
            level = Level.valueOf(readln().toUpperCase());

            for( int key : membershipService.getMemberRegistry().getMembers().keySet() ) {
                if( membershipService.getMemberRegistry().getMembers().get( key ).getLevel().equals( level ) )
                    print( membershipService.getMemberRegistry().getMembers().get( key ) ) ;
            }
        }

        catch ( IllegalArgumentException e ) {
            println( "finns ingen sådan medlemsnivå\n" );
        }

        catch (RuntimeException e)  { println( "någonting gick fel\n" ); }

        println("");
    }
}
