package com.simon.database;

import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;

import java.util.HashMap;

import static java.lang.IO.println;

public class Inventory {

    private HashMap<Integer, InventoryEntry> inventory = new HashMap<>();

    public void loadFromDatabase( ) {

        Item skyrim    = new VideoGame(0, "Skyrim", "video game", "pc", "PEGI18"  );
        Item minecraft = new VideoGame(1, "minecraft", "video game", "x-box", "PEGI7"  );

        Item theMatrix = new Movie( 2, "The Matrix", "movie", "dvd", "136" );
        Item Titanic   = new Movie( 3, "Titanic", "movie", "bluray", "194" );

        inventory.put( skyrim.getId(), new InventoryEntry( skyrim, 2 ) );
        inventory.put( minecraft.getId(), new InventoryEntry( minecraft, 4 ) );

        inventory.put( theMatrix.getId(), new InventoryEntry( theMatrix, 3 ) );
        inventory.put( Titanic.getId(), new InventoryEntry( Titanic, 1 ) );
    }

    public HashMap<Integer, InventoryEntry> getInventory() {

        return this.inventory;
    }
}
