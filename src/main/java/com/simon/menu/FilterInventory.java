package com.simon.menu;

import static java.lang.IO.*;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.regex.Regex;

public class FilterInventory {

    public static void filter(Inventory inventory) {

        try {
            final int choice;
            println( "\nFILTRERA ARTIKLAR I LAGRET" );
            println( "Välj filtreringssätt: ");
            println( "1. id");
            println( "2. regex find titel ");
            println( "3. regex match titel ");
            println( "4. kategori ");
            print( "välj : ");
            choice = Integer.parseInt( readln() );

            switch (choice) {
                case 1 -> filterByID( inventory );
                case 2 -> searchByRegexTitle( inventory, "find" );
                case 3 -> searchByRegexTitle( inventory, "match" );
                case 4 -> searchByCategory( inventory );
                default -> { }
            }
        }

        catch(NumberFormatException e) {
            println( "alla invärden ska vara icke negativa heltal\n" );
        }

        catch (RuntimeException e)  {}
    }

    public static void filterByID( Inventory inventory) {

        final int id;
        print( "välj id att söka på: " );

        try {
            id = Integer.parseInt(readln() );
            InventoryEntry inventoryEntry = inventory.getInventory().get( id );

            if( inventoryEntry != null )
                println( inventoryEntry );
            else
                println( "det finns ingenting i lagret med den titeln" );
        }

        catch( NullPointerException e ) {

            println( "ingen vara i lagret med det id:t" );
        }

        catch ( NumberFormatException e) {
            println( "alla invärden ska vara icke negativa heltal\n" );
        }

        catch ( RuntimeException e) { println( "någonting gick fel\n" ); }


        println("");
    }

    public static void searchByRegexTitle( Inventory inventory, String regexType ) {

        try {
            String pattern;
            print("Skriv in mönster: ");
            pattern = readln();

            for ( Integer key : inventory.getInventory().keySet() ) {

                final InventoryEntry inventoryEntry = inventory.getInventory().get( key );

                switch( regexType ) {
                    case "find"  ->  { if ( Regex.isFound( inventoryEntry.getItem().getTitle(), pattern) ) println( inventoryEntry ); }
                    case "match" ->  { if ( Regex.isMatch( inventoryEntry.getItem().getTitle(), pattern) ) println( inventoryEntry ); }
                }
            }
        }

        catch (RuntimeException e)  {}

        println("");
    }

    public static void searchByCategory( Inventory inventory ) {

        print( "skriv in kategori du vill söka på: " );
        String category = readln();

        for( Integer key: inventory.getInventory().keySet() ) {

            if( inventory.getInventory().get( key ).getItem().getCategory().equals( category ) )
                println(  inventory.getInventory().get( key ) );
        }

        println("");
    }
}
