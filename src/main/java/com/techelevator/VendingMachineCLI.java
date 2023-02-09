package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	public static void main(String[] args) {
		File inventoryFile = new File("vendingmachine.csv");
		try (Scanner textInput = new Scanner(inventoryFile)) {
		} catch (FileNotFoundException e) {
		}

	}
}
