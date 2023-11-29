package com.company;

import java.util.Scanner;

public class Item extends Shop{
    private int id;
    private String name;
    private int price;

    Item(){}

    Item (int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer setId (){
        System.out.println("Введите id:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public String setName (){
        System.out.println("Введите name:");
        Scanner sc = new Scanner(System.in);
        return sc.next();

    }

    public int setPrice (){
        System.out.println("Введите price:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

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
