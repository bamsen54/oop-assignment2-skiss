package com.simon.rental;

import com.simon.item.Item;
import com.simon.member.Member;

public class Rental {

    private Member member;
    private Item item;
    private String duration;

    public Rental() {
    }

    public Rental(Member member, Item item, String duration ) {
        this.member = member;
        this.item = item;
        this.duration = duration;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( this.member.getName() ).append( " hyr " ).
                      append( this.item ).append( " i " ).append( this.duration ).append( " dagar " );

        return stringBuilder.toString();
    }
}
