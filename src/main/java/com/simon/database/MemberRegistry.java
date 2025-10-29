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
        this.addMember( new Member( 0, "simon",    Level.STUDENT ) );
        this.addMember( new Member( 1, "simona",   Level.STANDARD ) );
        this.addMember( new Member( 2, "korina",   Level.STANDARD ) );
        this.addMember( new Member( 3, "sara",     Level.STANDARD ) );
        this.addMember( new Member( 4, "dennis",   Level.PREMIUM ) );
        this.addMember( new Member( 5, "billy",    Level.PREMIUM ) );
        this.addMember( new Member( 6, "kristina", Level.PREMIUM ) );

    }

    public void loadRentalsFromDatabase( Inventory inventory ) {

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
