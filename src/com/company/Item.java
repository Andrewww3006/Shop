package com.company;

import java.util.Scanner;

public class Item extends Shop{
    private int id;
    private String name;
    private int price;

    Item (int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId (){
        System.out.println("Введите id:");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();

    }

    public void setName (){
        System.out.println("Введите name:");
        Scanner sc = new Scanner(System.in);
        name = sc.next();

    }

    public void setPrice (){
        System.out.println("Введите price:");
        Scanner sc = new Scanner(System.in);
        price = sc.nextInt();

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

    public void editItem(){
        setId();
        setName();
        setPrice();
    }

}
