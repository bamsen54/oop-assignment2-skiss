package com.simon.service;

import com.simon.database.Inventory;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;

public class MembershipService {

    MemberRegistry memberRegistry = new MemberRegistry();

    public MembershipService(Inventory inventory) {
        memberRegistry.loadFromDatabase();
        memberRegistry.loadRentalsFromDatabase( inventory );
    }

    public MemberRegistry getMemberRegistry() {
        return this.memberRegistry;
    }

    public void setMemberRegistry(MemberRegistry memberRegistry) {
        this.memberRegistry = memberRegistry;
    }

    public void addNewMember(Member member) {

        this.memberRegistry.addMember( member );
    }
}
