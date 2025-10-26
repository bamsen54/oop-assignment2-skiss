package com.simon.menu;

import static java.lang.IO.*;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner( System.in );

    public void display() {

        println( "1. Lägg til ny medlem" );
        println( "2. Redigera befintlig medlem" );
        println( "3. Sök medlemmar " );
        println( "4. Boka hyrning" );
        println( "5. Avsluta hyrning" );
        println( "6. Skriv ut artiklar i lagret" );
        println( "7. Filtrera artiklar i lagret ");
        println( "8. Avsluta programmet " );
    }

    // user chooses in the main menu and
    public Integer getUserChoice() {

        Integer userChoice = null;

        try {
            print( "Välj: " );
            userChoice = Integer.parseInt( IO.readln( ) );
        }

        catch ( NumberFormatException e ) {
            println("det du skrev in är inte ett heltal\n");
        }

        if( userChoice != null ) {
            if (userChoice < 1 || userChoice > 8)
                println("det du skrev var inte mellan 1 och 8\n");
        }

        return userChoice;
    }
}
