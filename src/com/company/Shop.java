package com.company;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private final Map <Integer, Item> itemHashMap = new HashMap<>();

    Shop (){}


    public void adItem (Item item){

        Integer key = item.getId();

           itemHashMap.putIfAbsent(key, item);
               for (Map.Entry<Integer, Item> items : itemHashMap.entrySet())
                   System.out.println(items.getKey() + items.getValue().getName() + items.getValue().getPrice());


    }
    

    

}
