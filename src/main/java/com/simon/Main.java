package com.simon;

import static java.lang.IO.println;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.database.MemberRegistry;
import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;
import com.simon.member.Member;
import com.simon.menu.AddNewMemberMenu;
import com.simon.menu.EditMemberMenu;
import com.simon.menu.MainMenu;
import com.simon.menu.SearchMemberMenu;

public class Main {

    private static final MemberRegistry memberRegistry = new MemberRegistry();
    private static final Inventory inventory           = new Inventory();

    void main() {

        inventory.loadFromDatabase();

        memberRegistry.addMember( new Member( 0, "simon",  Level.STUDENT ) );
        memberRegistry.addMember( new Member( 1, "simona",   Level.STANDARD ) );
        memberRegistry.addMember( new Member( 2, "dennis", Level.PREMIUM ) );
        memberRegistry.addMember( new Member( 3, "billy",  Level.PREMIUM ) );

        run();
    }

    public static void run() {

        while(true) {

            MainMenu.display();
            final Integer userChoice = MainMenu.getUserChoice();

            if( userChoice == null )
                continue;

            switch (userChoice) {
                case 1 -> AddNewMemberMenu.addNewMember( memberRegistry );
                case 2 -> EditMemberMenu.editMember( memberRegistry );
                case 3 -> SearchMemberMenu.searchMember( memberRegistry );
                case 4 -> { /* Book rental */ }
                case 5 -> { /* end rental */  }
                case 6 -> { /* list items */  }
                case 7 -> { }
                case 9 -> {  }
                case 10 -> System.exit( 1 );
            }
        }
    }
}
