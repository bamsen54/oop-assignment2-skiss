package com.simon;

import static java.lang.IO.println;

import com.simon.database.Inventory;
import com.simon.database.InventoryEntry;
import com.simon.service.MembershipService;
import com.simon.item.Item;
import com.simon.item.Movie;
import com.simon.item.VideoGame;
import com.simon.member.Member;
import com.simon.menu.*;
import com.simon.rental.Rental;
import com.simon.service.MembershipService;
import com.simon.service.RentalService;

import java.util.PrimitiveIterator;

public class Main {

    private static final RentalService rentalService = new RentalService();
    private static final Inventory inventory           = new Inventory();
    private static MembershipService memberShipService;

    void main() {

        inventory.loadFromDatabase();
        memberShipService = new MembershipService( inventory );

        run();
    }

    public static void run() {

        while(true) {

            MainMenu.display();
            final Integer userChoice = MainMenu.getUserChoice();

            if( userChoice == null )
                continue;

            switch (userChoice) {
                case 1 -> AddNewMemberMenu.addNewMember( memberShipService );
                case 2 -> EditMemberMenu.editMember( memberShipService );
                case 3 -> SearchMemberMenu.searchMember( memberShipService );
                case 4 -> BookRentalMenu.bookRental( rentalService, memberShipService, inventory );
                case 5 -> EndRentalMenu.endRental( rentalService, memberShipService, inventory );
                case 6 -> PrintInventory.print(  inventory );
                case 7 ->  FilterInventory.filter( inventory );
                case 9 -> PrintHistoryMenu.printHistory( memberShipService );
                //case 10 -> System.exit( 1 );
                case 10 -> {
                    return;
                }
            }
        }
    }
}
