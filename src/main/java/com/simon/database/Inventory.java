package com.simon.database;

import java.util.HashMap;

import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;

public class Inventory {

    private HashMap<Integer, InventoryEntry> inventory = new HashMap<>();

    public Inventory() {
    }

    public void loadFromDatabase( ) {

        Item skyrim         = new VideoGame( 0, "Skyrim",         "tv-spel", "pc",    "PEGI18" );
        Item minecraft      = new VideoGame (1, "Minecraft",      "tv-spel", "x-box", "PEGI7" );
        Item rocketleague   = new VideoGame( 2, "Rocket League",  "tv-spel", "pc",    "PEGI3+" );
        Item desperados3    = new VideoGame( 3, "Desperados III", "tv-spel", "pc",    "PEGI18" );
        Item battlefield1   = new VideoGame( 4, "Battlefield 1",  "tv-spel", "ps",    "PEGI16" );

        Item thematrix      = new Movie( 5, "The Matrix",       "film", "dvd",    "136" );
        Item psycho         = new Movie( 6, "Psycho",           "film", "dvd",    "109" );
        Item theseventhseal = new Movie( 7, "The Seventh Seal", "film", "dvd",    "96" );
        Item wicked         = new Movie( 8, "Wicked",           "film", "bluray", "161" );
        Item titanic        = new Movie( 9, "Titanic",          "film", "bluray", "194" );

        inventory.put( skyrim.getId(),         new InventoryEntry( skyrim,         1 ) );
        inventory.put( minecraft.getId(),      new InventoryEntry( minecraft,      4 ) );
        inventory.put( rocketleague.getId(),   new InventoryEntry( rocketleague,   3 ) );
        inventory.put( desperados3.getId(),    new InventoryEntry( desperados3,    1 ) );
        inventory.put( battlefield1.getId(),   new InventoryEntry( battlefield1,   7 ) );

        inventory.put( thematrix.getId(),      new InventoryEntry( thematrix,      3 ) );
        inventory.put( psycho.getId(),         new InventoryEntry( psycho,         1 ) );
        inventory.put( wicked.getId(),         new InventoryEntry( wicked,         5 ) );
        inventory.put( theseventhseal.getId(), new InventoryEntry( theseventhseal, 2 ) );
        inventory.put( titanic.getId(),        new InventoryEntry( titanic,        1 ) );
    }

    public HashMap<Integer, InventoryEntry> getInventory() {

        return this.inventory;
    }
}
