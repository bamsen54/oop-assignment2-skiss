package com.simon;

import static java.lang.IO.println;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.database.MemberRegistry;
import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;
import com.simon.member.Member;
import com.simon.menu.*;
import com.simon.rental.Rental;

import java.util.PrimitiveIterator;

public class Main {

    private static final MemberRegistry memberRegistry = new MemberRegistry();
    private static final Inventory inventory           = new Inventory();

    void main() {

        inventory.loadFromDatabase();
        memberRegistry.loadFromDatabase();
        memberRegistry.loadRentalsFromDatabase( inventory );

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
                case 4 -> BookRentalMenu.bookRental( memberRegistry, inventory );
                case 5 -> EndRentalMenu.endRental( memberRegistry, inventory );
                case 6 -> PrintInventory.print(  inventory );
                case 7 -> { }
                case 9 -> {  }
                //case 10 -> System.exit( 1 );
                case 10 -> {
                    return;
                }
            }
        }
    }
}
