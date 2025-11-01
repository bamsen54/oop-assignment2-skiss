package com.simon.service;

import com.simon.Level;
import com.simon.database.Inventory;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;

public class MembershipService {

    MemberRegistry memberRegistry = new MemberRegistry();

    public MembershipService(Inventory inventory) {
        memberRegistry.loadFromDatabase();
    }

    public MemberRegistry getMemberRegistry() {
        return this.memberRegistry;
    }

    public void setMemberRegistry(MemberRegistry memberRegistry) {
        this.memberRegistry = memberRegistry;
    }

    public boolean hasMemberWithID( int id ) {
        return this.memberRegistry.hasMemberId( id );
    }

    public Member getMemberWithID( int id ) {
        return this.memberRegistry.getMember( id );
    }

    public void addNewMember(Member member, IncomeService incomeService) {

        this.memberRegistry.addMember( member );
        incomeService.handleEntryFeePaymen( member, null );
    }
}
