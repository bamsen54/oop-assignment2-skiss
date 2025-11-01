package com.simon.database;

import com.simon.item.Item;

public class InventoryEntry {

    private Item item;
    private int quantityInStore;

    public InventoryEntry() {
    }

    public InventoryEntry(Item item, int quantityInStore) {
        this.item = item;
        this.quantityInStore = quantityInStore;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantityInStore() {
        return this.quantityInStore;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( this.item.toString() );
        stringBuilder.append( " antal i lager: " ).append( this.quantityInStore );

        return stringBuilder.toString();
    }
}
