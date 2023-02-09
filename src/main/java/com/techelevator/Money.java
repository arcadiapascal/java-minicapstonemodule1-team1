package com.techelevator;

import java.math.BigDecimal;

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
}
