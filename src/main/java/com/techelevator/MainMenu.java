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
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            String option = userInput.nextLine();
            if (option.equals("1")) {
                for (Map.Entry<Integer, Item> element : inventoryMap.entrySet()) {
                    if (element.getValue().getQuantity() == 0) {
                        System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " " + element.getValue().getPrice() + " SOLD OUT");

                    } else
                    System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " " + element.getValue().getPrice() + " quantity: " + element.getValue().getQuantity());
                }
                System.out.println();

            } else if (option.equals("2")) {
                // Purchase
                PurchaseMenu purchaseMenu = new PurchaseMenu();
                purchaseMenu.purchaseMenu(inventoryMap);
                validEntry = true;
            } else if (option.equals("3")) {
                // Exit
                System.out.println("Goodbye!");
                validEntry = true;
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

