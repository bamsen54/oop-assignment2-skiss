package com.simon.member;

import java.time.LocalDateTime;

import com.simon.item.Item;
import com.simon.time.LocalDateTimeToString;

public class HistoryEntry {

    private Item item;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    public HistoryEntry() {
    }

    public HistoryEntry(Item item, LocalDateTime rentalDate, LocalDateTime returnDate) {
        this.item = item;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( this.item );
        stringBuilder.append( " hyrning: " ).append( LocalDateTimeToString.toString( this.rentalDate ) ).append( " retur: " ).
        append( LocalDateTimeToString.toString( this.returnDate ) );
        return stringBuilder.toString();
    }
}
