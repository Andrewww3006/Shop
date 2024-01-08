package com.company;

import java.util.Comparator;
import java.util.Scanner;

public class Item {
    private int id;
    private String name;
    private int price;

    public Item(){};

    Item (int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }



}
