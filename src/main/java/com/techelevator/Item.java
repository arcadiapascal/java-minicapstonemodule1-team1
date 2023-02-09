package com.techelevator;

import java.math.BigDecimal;

public class Item {
   // Properties
    private BigDecimal price;
    private String sound;
    private String name;
    private String species;
    private int quantity;
    private String slot;
    //Constructor
    public Item(String slot, String name, BigDecimal price, String species) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.species = species;
        quantity = 5;
        //sets sound to right species
        if (species.equals("Penguin")) {
            sound = "Squawk, Squawk, Whee!";
        }
        else if(species.equals("Duck")) {
            sound="Quack, Quack, Splash!";
        }
        else if(species.equals("Cat")) {
            sound="Meow, Meow, Meow!";
        }
        else if(species.equals("Pony")) {
            sound="Neigh, Neigh, Yay!";
        }

    }
    //Getters and Setters for properties
    public BigDecimal getPrice(){
        return price;
    }
    public String getSound(){
        return sound;
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getSlot(){
        return slot;
    }
    public void setQuantity(int quantity){
        this.quantity= quantity;
    }

}



