package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {


    public String setupInventory() {
        File inventoryFile = new File("vendingmachine.csv");
        try (Scanner textInput = new Scanner(inventoryFile)) {
            while(textInput.hasNextLine()) {
                String lineOfInput = textInput.nextLine();
                String[] itemInfoArray = lineOfInput.split("|");
                Item "(itemInfoArray[0])" = new item;
            }
        }
                catch (FileNotFoundException e) {
        }

    }

}
