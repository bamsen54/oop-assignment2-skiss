package com.simon;

import com.simon.database.Inventory;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;
import com.simon.menu.*;
import com.simon.service.RentalService;

public class Main {

    private static final Inventory inventory           = new Inventory();
    private static final RentalService rentalService   = new RentalService();
    private static MembershipService memberShipService;
    private static final IncomeService incomeService = new IncomeService();

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
                case 1 -> AddNewMemberMenu.addNewMember( memberShipService, incomeService );
                case 2 -> EditMemberMenu.editMember( memberShipService );
                case 3 -> SearchMemberMenu.searchMember( memberShipService );
                case 4 -> BookRentalMenu.bookRental( rentalService, memberShipService, inventory, incomeService );
                case 5 -> EndRentalMenu.endRental( rentalService, memberShipService, inventory );
                case 6 -> PrintInventory.print(  inventory );
                case 7 ->  FilterInventory.filter( inventory );
                case 9 -> PrintHistoryMenu.printHistory( memberShipService );
                case 10 -> incomeService.printIncomeSummary();
                case 11 -> {
                    return;
                }
            }
        }
    }
}
