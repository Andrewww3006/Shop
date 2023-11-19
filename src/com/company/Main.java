package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Item sox = new Item(1, "Sox", 3 );
        Shop dressShop = new Shop();
        dressShop.adItem(sox);
        Item shoes = new Item(2,"Shoes", 100);
        dressShop.adItem(shoes);
    }
}
