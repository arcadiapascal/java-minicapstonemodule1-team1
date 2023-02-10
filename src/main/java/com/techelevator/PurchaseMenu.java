package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class PurchaseMenu {

    public void purchaseMenu(Map<Integer, Item> inventory) {
        Money money = new Money();

        Scanner userInput = new Scanner(System.in);
        boolean validEntry = false;
        while (validEntry == false) {
            System.out.println();
            System.out.println("Current Money Provided: ");
            System.out.println();
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            String option = userInput.nextLine();
            if (option.equals("1")) {
                // Feed Money
//                System.out.println();
//                System.out.println("Current money provided: $" + money.getBalance());
//                System.out.println("Please enter bills.");
//                String bills = userInput.nextLine();
//                BigDecimal stringToDec = new BigDecimal(bills);
//                money.feedMoney(stringToDec);
                validEntry = true;

            } else if (option.equals("2")) {
                System.out.println("Please enter slot ID or 0 to exit: ");
                String slotID = userInput.nextLine();
                if (!slotID.equals("0")) {
                    Item selectedItem = money.purchase(slotID, inventory);
                    if (selectedItem == null) {
                        System.out.println("Invalid entry.");
                    }
                    else {
                        System.out.println(selectedItem.getName() + " " + selectedItem.getPrice() + " " + money.getBalance() + " " + selectedItem.getSound());
                    }

                }
                else if (slotID.equals("0")){
                    validEntry = false;
                }
                else {
                    System.out.println("Invalid entry.");
                }

            }
            else if (option.equals("3")) {
                // Finish
                validEntry = true;

            } else {
                System.out.println("Invalid Entry - Select 1, 2, or 3");
            }
        } userInput.close();
    }

}
