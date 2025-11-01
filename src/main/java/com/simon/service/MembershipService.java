package com.simon.service;

import com.simon.Level;
import com.simon.database.Inventory;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;


public class MembershipService {

    MemberRegistry memberRegistry = new MemberRegistry();

    public MembershipService(Inventory inventory) {
        memberRegistry.loadFromDatabase();
        //memberRegistry.loadRentalsFromDatabase( inventory );
    }

    public MemberRegistry getMemberRegistry() {
        return this.memberRegistry;
    }

    public void setMemberRegistry(MemberRegistry memberRegistry) {
        this.memberRegistry = memberRegistry;
    }

    public void addNewMember(Member member, IncomeService incomeService) {

        this.memberRegistry.addMember( member );

//        switch ( member.getLevel() ) {
//            case Level.STUDENT  -> incomeService.addEntryFees( new StudentPolicy().getEntryFee()  );
//            case Level.STANDARD -> incomeService.addEntryFees( new StandardPolicy().getEntryFee() );
//            case Level.PREMIUM  -> incomeService.addEntryFees( new PremiumPolicy().getEntryFee()  );
//        }

        incomeService.handleEntryFeePaymen( member );
    }
}
