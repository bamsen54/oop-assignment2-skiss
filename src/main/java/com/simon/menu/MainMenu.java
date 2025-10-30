package com.simon.menu;

import static java.lang.IO.*;

public class MainMenu {

    public static void display() {
        println( "1.  Lägg till ny medlem" );
        println( "2.  Redigera befintlig medlem" );
        println( "3.  Sök medlemmar " );
        println( "4.  Boka hyrning" );
        println( "5.  Avsluta hyrning" );
        println( "6.  Skriv ut artiklar i lagret" );
        println( "7.  Filtrera artiklar i lagret ");
        println( "8.  Skriv ut hyrhistoria för en medlem" );
        println( "9.  Summera intäkter" );
        println( "10. Avsluta" );
    }

    public static Integer getUserChoice() {

        Integer userChoice = null;

        try {
            print( "Välj: " );
            userChoice = Integer.parseInt( readln( ) );
        }

        catch ( NumberFormatException e ) {
            println("det du skrev in är inte ett heltal\n");
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }

        if( userChoice != null ) {
            if ( userChoice < 1 || userChoice > 10 )
                println( "det du skrev var inte mellan 1 och 11\n" );
        }

        return userChoice;
    }
}
