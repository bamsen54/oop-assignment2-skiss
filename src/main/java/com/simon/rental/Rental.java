package com.simon.rental;

import java.time.LocalDateTime;

import com.simon.item.Item;
import com.simon.member.Member;
import com.simon.time.LocalDateTimeToString;

public class Rental {

    private Member member;
    private Item item;
    private String duration;
    private LocalDateTime timeOfRental;

    public Rental() {
    }

    public Rental(Member member, Item item, String duration) {
        this.member = member;
        this.item = item;
        this.duration = duration;
        this.timeOfRental = LocalDateTime.now();
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDateTime getTimeOfRental() {
        return this.timeOfRental;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( this.member.getName() ).append( " hyr " ).
                      append( this.item ).append( " i " ).append( this.duration ).append( " dagar " );

        stringBuilder.append( "tid: " ).append( LocalDateTimeToString.toString( this.timeOfRental ) );

        return stringBuilder.toString();
    }
}
