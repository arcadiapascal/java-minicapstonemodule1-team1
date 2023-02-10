package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	public static void main(String[] args) {

//	Reads inventory file, Makes map
		File inventoryFile = new File("vendingmachine.csv");
		int count = 0;
		Map<Integer, Item> inventory = new HashMap<Integer, Item>();
		try (Scanner textInput = new Scanner(inventoryFile)) {
			while (textInput.hasNextLine()) {
				count++;
				String lineOfInput = textInput.nextLine();
				String[] itemInfoArray = lineOfInput.split("\\|");
				BigDecimal stringToDec = new BigDecimal(itemInfoArray[2]);
				Item a = new Item(itemInfoArray[0], itemInfoArray[1], stringToDec, itemInfoArray[3]);
				inventory.put(count, a);
			}
		} catch (FileNotFoundException e) {
		}

//	Makes new money object
		Money money = new Money();

//	Makes new main menu object & calls main menu method
		MainMenu mainMenu = new MainMenu();
			mainMenu.mainMenu(inventory);





	}

}