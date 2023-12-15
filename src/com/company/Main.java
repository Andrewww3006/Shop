package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Item sox = new Item(1, "Sox", 3);
        Shop dressShop = new Shop();
        dressShop.addItem(sox);
        Item shoes = new Item(2, "Shoes", 100);
        dressShop.addItem(shoes);
        Item dress = new Item(3, "Dress", 75);
        dressShop.addItem(dress);
        Item jacket = new Item(4, "Jacket", 175);
        dressShop.addItem(jacket);
        Item bag = new Item(5, "Bag", 89);
        dressShop.addItem(bag);
        Item pants = new Item(6, "Pants", 120);
        dressShop.addItem(pants);
        System.out.println("Список товаров:");
        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }
        System.out.println();

        System.out.println("Список товаров отсортированный по цене:");
        List<Item> listByPrice = new ArrayList<>(dressShop.getItemsList().values());
        Comparator<Item> itemComparator = new Shop.ItemPriceComparator();
        listByPrice.sort(itemComparator);

        for (Item item : listByPrice)
            System.out.println("id:" + item.getId() + "; Item: " + item.getName() + "; Price:" + item.getPrice() + '.');
        System.out.println();

        System.out.println("Удаляем товар по id:");
        dressShop.removeItemById(2);
        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }

        System.out.println();
        System.out.println("Список товара отсортированный по добавлению");

        Deque<Item> itemQueue = new ArrayDeque<>();

        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            itemQueue.addFirst(item.getValue());
        }
        while (!itemQueue.isEmpty())
            System.out.println("id: " + itemQueue.getFirst().getId() + "; Item: " + itemQueue.getFirst().getName() + "; Price:"
                    + itemQueue.removeFirst().getPrice() + '.');
        System.out.println("Редактируем товар по:");
        //dressShop.editItem(sox);
        for (Map.Entry<Integer, Item> item : dressShop.getItemsList().entrySet()) {
            System.out.println("id: " + item.getKey() + "; Item: " + item.getValue().getName() + "; Price:" + item.getValue().getPrice() + '.');
        }

        int ch;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("выберите действие");
            ch = scanner.nextInt();
            switch (ch) {
                    case 1:
                        Scanner scanner1 = new Scanner(System.in);
                        do {
                            System.out.println("выберите способ сортировки: 1. по цене(возрастание); 2. по цене(убывание); 3. по добавлению новые; 4. по добавлению старые");
                                if(scanner1.hasNextInt()){
                                int ch1 = scanner1.nextInt();
                                break;
                           } else System.out.println("вы ввели не правильное значение");

                        }while (scanner1.hasNextInt() == true);

                    break;
                }

            } while (ch != 0);

    }
}
