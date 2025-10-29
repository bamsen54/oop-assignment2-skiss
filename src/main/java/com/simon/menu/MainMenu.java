package com.simon.menu;

import static java.lang.IO.*;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    public static void display() {

        println( "1.  Lägg til ny medlem" );
        println( "2.  Redigera befintlig medlem" );
        println( "3.  Sök medlemmar " );
        println( "4.  Boka hyrning" );
        println( "5.  Avsluta hyrning" );
        println( "6.  Skriv ut artiklar i lagret" );
        println( "7.  Filtrera artiklar i lagret ");
        println( "8.  Visa inkomst denna månad " );
        println( "9.  Skriv ut hyrhistoria för en medlem" );
        println( "10. Summera intäkter" );
        println( "11. Avsluta" );
    }

    // user chooses in the main menu and
    public static Integer getUserChoice() {

        Integer userChoice = null;

        try {
            print( "Välj: " );
            userChoice = Integer.parseInt( IO.readln( ) );
        }

        catch ( NumberFormatException e ) {
            println("det du skrev in är inte ett heltal\n");
        }

        catch ( RuntimeException e ) {}

        if( userChoice != null ) {
            if (userChoice < 1 || userChoice > 10)
                println("det du skrev var inte mellan 1 och 11\n");
        }

        return userChoice;
    }
}
