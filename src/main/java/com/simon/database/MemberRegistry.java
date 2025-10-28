package com.simon.database;

import com.simon.Level;
import com.simon.member.Member;
import com.simon.rental.Rental;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRegistry {

    private final Map<Integer, Member> members = new HashMap<>();

    public MemberRegistry() {
    }

    public void  loadFromDatabase() {
        this.addMember( new Member( 0, "simon",  Level.STUDENT ) );
        this.addMember( new Member( 1, "simona",   Level.STANDARD ) );
        this.addMember( new Member( 2, "korina",   Level.STANDARD ) );
        this.addMember( new Member( 2, "sara",   Level.STANDARD ) );
        this.addMember( new Member( 2, "dennis", Level.PREMIUM ) );
        this.addMember( new Member( 3, "billy",  Level.PREMIUM ) );
    }

    public void loadRentalsFromDatabase( Inventory inventory ) {

        HashMap<Integer, InventoryEntry> ie = inventory.getInventory();
        this.members.get( 0 ).addToCurrentRentals( new Rental( this.members.get( 0 ), ie.get( 0 ).getItem(), "7" ) );
        this.members.get( 0 ).addToCurrentRentals( new Rental( this.members.get( 0 ), ie.get( 2 ).getItem(), "2" ) );
    }

    public boolean hasMemberId( int memberId ) {
        return members.containsKey(memberId);
    }

    public void addMember(Member member) {
        this.members.put( member.getId(), member );
    }

    public void removeMember(Member member) {
        this.members.remove( member.getId() );
    }

    public Member getMember(int id) {
        return this.members.get( id );
    }

    public HashMap<Integer, Member> getMembers() {
        return (HashMap<Integer, Member>) this.members;
    }
}
