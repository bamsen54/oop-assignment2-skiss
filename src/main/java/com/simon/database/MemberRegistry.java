package com.simon.database;

import com.simon.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRegistry {

    private Map<Integer, Member> members = new HashMap<>();

    public MemberRegistry() {
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

//    public void editMember(int id, Member member) {
//        this.members.put( id, member );
//    }
}
