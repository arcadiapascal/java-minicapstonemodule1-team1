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
        balance=balance.add(dollars);

    }

    public Item purchase(String userInput, Map<Integer, Item> inventoryMap) {
        for (Map.Entry<Integer, Item> element : inventoryMap.entrySet()) {
            if (userInput.toUpperCase().equals(element.getValue().getSlot()) && balance.compareTo(element.getValue().getPrice()) != -1) {
                if(element.getValue().getQuantity()==0){
                    System.out.println("SOLD OUT");
                }
                else {
                    balance=balance.subtract(element.getValue().getPrice());
                    Item selectedItem = element.getValue();
                    element.getValue().setQuantity(element.getValue().getQuantity()-1);
                    System.out.println(element.getValue().getQuantity());
                    return selectedItem;
                }
            }
            else if (userInput.toUpperCase().equals(element.getValue().getSlot()) && balance.compareTo(element.getValue().getPrice()) == -1) {
                System.out.println("Insufficient Funds");
            }
        }
        return null;
    }
    public String correctChange(){
        int quarterCount = 0;
        int dimeCount=0;
        int nickelCount=0;

        while(balance.compareTo(quarter) != -1){
            quarterCount++;
            balance=balance.subtract(quarter);
        }
        while(balance.compareTo(dime) != -1){
            dimeCount++;
            balance=balance.subtract(dime);
        }
        while(balance.compareTo(nickel) != -1){
            nickelCount++;
            balance=balance.subtract(nickel);
        }
        return "Change Due: "+ "\nQuarters: "+ quarterCount+"\n Dimes: "+ dimeCount+ "\n Nickels: " + nickelCount ;

    }
}
