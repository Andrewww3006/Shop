package com.company;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private final Map <Integer, Item> itemHashMap = new HashMap<>();

    Shop (){}


    public void adItem (Item item){

        Integer key = item.getId();

           itemHashMap.putIfAbsent(key, item);


    }

    public Map<Integer, Item> getItemsList (){
        return  itemHashMap;
    }

    public  void removeItemById (int id){
        if (itemHashMap.remove(id)!=null)
            itemHashMap.remove(id);
        else System.out.println("Illegal id");

    }
    public void editItem(Item item){
        itemHashMap.remove(item.getId());
        Item item2 = new Item(item.setId(), item.setName(), item.setPrice());
        itemHashMap.putIfAbsent(item2.getId(),item2);
    }



    

    

}
