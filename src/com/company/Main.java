package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Item sox = new Item(1, "Sox", 3 );
        Shop dressShop = new Shop();
        dressShop.adItem(sox);
        Item shoes = new Item(2,"Shoes", 100);
        dressShop.adItem(shoes);
        Item dress = new Item(3, "Dress", 75);
        dressShop.adItem(dress);


        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }

        dressShop.removeItemById(2);

        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }
        sox.editItem();
        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }

    }
}
