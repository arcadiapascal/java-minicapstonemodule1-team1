package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    BigDecimal moneyAdded;
    BigDecimal balance;
    String name;
    String slot;
    BigDecimal price;
    File logFile = new File("Log.txt");


    public Log (BigDecimal moneyAdded, BigDecimal balance) {
        this.moneyAdded = moneyAdded;
        this.balance = balance;
    }

    public void feedMoneyLog() {
        try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            log.println(dtf.format(now) + " FEED MONEY: $" + moneyAdded + " $" + balance);
        } catch (
                FileNotFoundException e) {

        }
    }


    public Log (String name, String slot, BigDecimal price, BigDecimal balance) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.balance = balance;
    }

    public void purchaseLog() {
        try (
                PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            log.println(dtf.format(now) + " " + name + " " + slot + " $" + price + " $" + balance);
        } catch (
                FileNotFoundException e) {

        }
    }


    public Log (BigDecimal balance) {
        this.balance = balance;
    }

    public void giveChangeLog() {
        try (
                PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            log.println(dtf.format(now) + " GIVE CHANGE: $" + balance + " $0.00");

        } catch (
                FileNotFoundException e) {

        }
    }

}
