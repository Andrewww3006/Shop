package com.company;
import java.util.HashMap;
import java.util.Map;

public class Shop{
    private Map <Integer, Item> itemMap = new HashMap<>();
    public Shop (){}
    public Map<Integer, Item> getItemsMap(){
        return  itemMap;
    }
}
