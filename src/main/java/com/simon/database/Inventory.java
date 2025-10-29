package com.simon.database;

import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;

import java.util.HashMap;

import static java.lang.IO.println;

public class Inventory {

    private HashMap<Integer, InventoryEntry> inventory = new HashMap<>();

    public Inventory() {
    }

    public void loadFromDatabase( ) {

        Item skyrim    = new VideoGame(0, "Skyrim", "tv-spel", "pc", "PEGI18"  );
        Item minecraft = new VideoGame(1, "Minecraft", "tv-spel", "x-box", "PEGI7"  );
        Item eldenring = new VideoGame( 2, "Elden Ring", "tv-spel", "pc", "PEGI17+" );

        Item theMatrix = new Movie( 5, "The Matrix", "film", "dvd", "136" );
        Item Titanic   = new Movie( 9, "Titanic", "film", "bluray", "194" );

        inventory.put( skyrim.getId(), new InventoryEntry( skyrim, 1 ) );
        inventory.put( minecraft.getId(), new InventoryEntry( minecraft, 4 ) );
        inventory.put( eldenring.getId(), new InventoryEntry( eldenring, 3 ) );

        inventory.put( theMatrix.getId(), new InventoryEntry( theMatrix, 3 ) );
        inventory.put( Titanic.getId(), new InventoryEntry( Titanic, 1 ) );

    }

    public HashMap<Integer, InventoryEntry> getInventory() {

        return this.inventory;
    }
}
