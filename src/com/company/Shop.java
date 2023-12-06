package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Shop{

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


    static class ItemPriceComparator implements Comparator<Item>{
        @Override
        public int compare(Item o1, Item o2) {
            if(o1.getPrice() > o2.getPrice())
            return 1;
            else if (o1.getPrice() < o2.getPrice())
           return -1;
            else
            return 0;
        }
    }


}
