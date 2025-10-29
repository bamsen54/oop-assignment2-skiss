package com.simon;

// Simon Toivola SY25 Objektorienterad Programmering Uppgift 1

import com.simon.database.Inventory;
import com.simon.service.IncomeService;
import com.simon.service.MembershipService;
import com.simon.menu.*;
import com.simon.service.RentalService;

public class Main {

    private static final Inventory inventory           = new Inventory();
    private static final RentalService rentalService   = new RentalService();
    private static final IncomeService incomeService   = new IncomeService();
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
                case 1  ->  AddNewMemberMenu.addNewMember( memberShipService, incomeService );
                case 2  ->  EditMemberMenu.editMember( memberShipService, incomeService );
                case 3  ->  SearchMemberMenu.searchMember( memberShipService );
                case 4  ->  BookRentalMenu.bookRental( rentalService, memberShipService, inventory, incomeService );
                case 5  ->  EndRentalMenu.endRental( rentalService, memberShipService, inventory );
                case 6  ->  PrintInventory.print(  inventory );
                case 7  ->  FilterInventory.filter( inventory );
                case 8  ->  PrintHistoryMenu.printHistory( memberShipService );
                case 9  ->  incomeService.printIncomeSummary();
                case 10 ->  { return; }
            }
        }
    }
}
