package com.techelevator;

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
                System.out.println();
                System.out.println("Current money provided: $" + money.getBalance());
                System.out.println("Please enter bills.");
                String bills = userInput.nextLine();


                validEntry = true;
            } else if (option.equals("2")) {
                // Select Product
                validEntry = true;
            } else if (option.equals("3")) {
                // Finish
                validEntry = true;
            } else {
                System.out.println("Invalid Entry - Select 1, 2, or 3");
            }
        } userInput.close();
    }

}
