package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class PurchaseMenu {

    public void purchaseMenu(Map<Integer, Item> inventory) {
        Money money = new Money();



        Scanner userInput = new Scanner(System.in);
        boolean validEntry = false;
        while (validEntry == false) {
 // PRINTS PURCHASE MENU
            System.out.println();
            System.out.println("Current Money Provided: $"+ money.getBalance());
            System.out.println();
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            String option = userInput.nextLine();

// OPTION 1: PRINTS FEED MONEY INSTRUCTIONS
            if (option.equals("1")) {
                System.out.println();
                System.out.println("Current money provided: $" + money.getBalance());
                System.out.println();
                System.out.println("Please enter bills as 1, 5, 10, or 20 or enter 0 to exit.");

// CONVERTING BILLS INTO BIG DECIMALS, ADDS INPUT TO BALANCE, ADDS LOG ENTRY
                try  {
                    String bills = userInput.nextLine();
                    BigDecimal stringToDec = new BigDecimal(bills);
                    money.feedMoney(stringToDec);
                    Log feedLog = new Log(stringToDec, money.getBalance());
                    feedLog.feedMoneyLog();
                } catch (NumberFormatException e) {System.out.println("Invalid Entry. Please enter valid bills.");}

// OPTION 2: PURCHASE ITEM
            } else if (option.equals("2")) {
                // PRINT INVENTORY
                for (Map.Entry<Integer, Item> element : inventory.entrySet()) {
                    if (element.getValue().getQuantity() == 0) {
                        System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " " + element.getValue().getPrice() + " SOLD OUT");

                    } else
                        System.out.println(element.getValue().getSlot() + " " + element.getValue().getName() + " Price: " + element.getValue().getPrice() + " Quantity: " + element.getValue().getQuantity());
                }
                // PRINT PURCHASE INSTRUCTIONS, TAKE USER INPUT
                System.out.println();
                System.out.println("Please enter slot ID or 0 to exit: ");
                String slotID = userInput.nextLine();
                //CHECKS FOR VALID ENTRY, MAKES PURCHASE
                if (!slotID.equals("0")) {
                    Item selectedItem = money.purchase(slotID, inventory);
                    if (selectedItem == null) {
                        System.out.println();
                        System.out.println("Please make a different selection.");
                    }
                    // MAKES LOG ENTRY
                    else {
                        Log purchaseLog = new Log(selectedItem.getName(), selectedItem.getSlot(), selectedItem.getPrice(), money.getBalance());
                        purchaseLog.purchaseLog();
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
// OPTION 3: CALCULATES CHANGE IN COINS, MAKES LOG ENTRY, RETURNS TO MAIN MENU
            else if (option.equals("3")) {
                Log getChangeLog = new Log(money.getBalance());
                getChangeLog.giveChangeLog();
                String totalChange = money.correctChange();
                System.out.println(totalChange);
                validEntry = true;
                System.out.println();
                MainMenu mainMenu = new MainMenu();
                mainMenu.mainMenu(inventory);

            } else {
                System.out.println("Invalid Entry - Select 1, 2, or 3");
            }
        } userInput.close();
    }


}
