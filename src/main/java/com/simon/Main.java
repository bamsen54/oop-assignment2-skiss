package com.simon;

import static java.lang.IO.println;

import com.simon.database.Inventory;
import com.simon.database.MemberRegistry;
import com.simon.member.Member;
import com.simon.Level;
import com.simon.menu.AddNewMemberMenu;
import com.simon.menu.EditMemberMenu;
import com.simon.menu.MainMenu;


public class Main {

    private static MemberRegistry memberRegistry = new MemberRegistry();
    private static Inventory inventory           = new Inventory();

    private static MainMenu mainMenu                 = new MainMenu();
    private static AddNewMemberMenu addNewMemberMenu = new AddNewMemberMenu();
    private static EditMemberMenu editMemberMenu     = new EditMemberMenu();

    void main() {
        memberRegistry.addMember( new Member(0, "simon", Level.STUDENT ) );
        run();
    }

    public static void run() {

        while(true) {

            mainMenu.display();
            final Integer userChoice = mainMenu.getUserChoice();

            if( userChoice == null )
                continue;

            switch (userChoice) {
                case 1 -> { addNewMemberMenu.addNewMember( memberRegistry );  }
                case 2 -> { editMemberMenu.editMember( memberRegistry );  }
                case 3 -> { /*search for members   */  }
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
