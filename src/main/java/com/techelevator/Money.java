package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class Money {


    private final BigDecimal quarter = BigDecimal.valueOf(0.25);
    private final BigDecimal nickel = BigDecimal.valueOf(0.05);
    private final BigDecimal dime = BigDecimal.valueOf(0.10);
    private BigDecimal balance = BigDecimal.valueOf(0.00);

    public BigDecimal getBalance() {
        return balance;
    }


    public void feedMoney(BigDecimal dollars) {
        balance.add(dollars);
    }

    public Item purchase(String userInput, Map<Integer, Item> inventoryMap) {
        for (Map.Entry<Integer, Item> element : inventoryMap.entrySet()) {
            if (userInput.toUpperCase().equals(element.getValue().getSlot()) && balance.compareTo(element.getValue().getPrice()) != -1) {
                balance.subtract(element.getValue().getPrice());
                Item selectedItem = element.getValue();
                return selectedItem;
            }
            }
        return null;
        }

    }
