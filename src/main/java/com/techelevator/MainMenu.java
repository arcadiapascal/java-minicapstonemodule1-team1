package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class MainMenu {


    public MainMenu() {
    }


    public void mainMenu(Map<Integer, Item> inventoryMap) {
        Scanner userInput = new Scanner(System.in);
        boolean validEntry = false;
        while (validEntry == false) {
 // Print main menu options
            System.out.println();
            System.out.println("Welcome to the Vendo-Matic 800 by CuteCo, Inc.");
            System.out.println();
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            String option = userInput.nextLine();
//  OPTION 1: PRINTS INVENTORY
            if (option.equals("1")) {
                for (Map.Entry<Integer, Item> element : inventoryMap.entrySet()) {
                    if (element.getValue().getQuantity() == 0) {
                        System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " " + element.getValue().getPrice() + " SOLD OUT");

                    } else
                    System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " " + element.getValue().getPrice() + " quantity: " + element.getValue().getQuantity());
                }
                System.out.println();
//  OPTION 2: NAVIGATES TO PURCHASE MENU
            } else if (option.equals("2")) {

                PurchaseMenu purchaseMenu = new PurchaseMenu();
                purchaseMenu.purchaseMenu(inventoryMap);
                validEntry = true;
 // OPTION 3: EXITS
            } else if (option.equals("3")) {

                System.out.println("Goodbye!");
                validEntry = true;
 // OPTION 4:(NOT CREATED) EXITS CURRENTLY
            } else if (option.equals("4")) {
                //Sales report
                validEntry = true;
            }else {
                System.out.println("Invalid Entry - Select 1, 2, or 3");
            }
        }
        userInput.close();
    }



}

