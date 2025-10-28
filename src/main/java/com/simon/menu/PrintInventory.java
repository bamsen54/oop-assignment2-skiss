package com.simon.menu;

import static java.lang.IO.*;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;

public class PrintInventory {

    public static void print(Inventory inventory) {

        println( "I lager: " );
        for( Integer key: inventory.getInventory().keySet() )
            println( inventory.getInventory().get( key ) );

        println("");
    }
}
