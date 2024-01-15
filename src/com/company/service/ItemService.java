package com.company.service;

import com.company.Item;
import com.company.Shop;

import java.util.*;

public class ItemService {

    Shop shop = new Shop();

    public void sortingMap() {
        System.out.println("выберите способ сортировки: 1. по цене(возрастание); 2. по цене(убывание); 3. по добавлению новые; 4. по добавлению старые");
        Scanner scannerSorting = new Scanner(System.in);
        do {
            if (scannerSorting.hasNextInt()) {
                int ch1 = scannerSorting.nextInt();
                List<Item> listByPrice = new ArrayList<>(shop.getItemsMap().values());
                if (ch1 == 1) {
                    listByPrice.sort(Comparator.comparing(Item::getPrice));
                    for (Item item : listByPrice)
                        System.out.println("id:" + item.getId() + "; Item: " + item.getName() + "; Price:" + item.getPrice() + "; Date:" + item.getDate());
                    System.out.println();
                }
                if (ch1 == 2) {
                    listByPrice.sort(Comparator.comparing(Item::getPrice).reversed());
                    for (Item item : listByPrice)
                        System.out.println("id:" + item.getId() + "; Item: " + item.getName() + "; Price:" + item.getPrice() + "; Date:" + item.getDate());
                    System.out.println();
                }

                if (ch1 == 3) {
                    Deque<Item> itemQueue = new ArrayDeque<>();
                    for (Map.Entry<Integer, Item> item : shop.getItemsMap().entrySet()) {
                        itemQueue.addFirst(item.getValue());
                    }
                    while (!itemQueue.isEmpty())
                        System.out.println("id: " + itemQueue.getFirst().getId() + "; Item: " + itemQueue.getFirst().getName() + "; Price:"
                                + itemQueue.getFirst().getPrice() + "; Date:" + itemQueue.removeFirst().getDate());
                }

                if (ch1 == 4) {
                    Deque<Item> itemQueue = new ArrayDeque<>();
                    for (Map.Entry<Integer, Item> item : shop.getItemsMap().entrySet()) {
                        itemQueue.addLast(item.getValue());
                    }
                    while (!itemQueue.isEmpty())
                        System.out.println("id: " + itemQueue.getFirst().getId() + "; Item: " + itemQueue.getFirst().getName() + "; Price:"
                                + itemQueue.getFirst().getPrice() + "; Date:" + itemQueue.removeFirst().getDate());
                }

                break;

            } else System.out.println("вы ввели не правильное значение");

        } while (scannerSorting.hasNextInt());
    }

    public void addItem() {
        Map<Integer, Item> itemMap = shop.getItemsMap();
        Item item = new Item();
        System.out.println("Введите id:");
        Scanner scId = new Scanner(System.in);
        int id = scId.nextInt();

        if (itemMap.containsKey(id)) {
            System.out.println("Товар с таким id уже существует");
        } else {
            item.setId(id);
            System.out.println("Введите name:");
            Scanner scName = new Scanner(System.in);
            item.setName(scName.nextLine());
            System.out.println("Введите price:");
            Scanner scPrice = new Scanner(System.in);
            item.setPrice(scPrice.nextInt());
            item.setDate();
            itemMap.put(item.getId(), item);
        }
    }

    public void removeItemById() {
        Map<Integer, Item> itemMap = shop.getItemsMap();
        System.out.println("Введите id товара, который нужно удалить");
        Scanner scannerRemoving = new Scanner(System.in);
        int id = scannerRemoving.nextInt();
        if (itemMap.containsKey(id)) {
            itemMap.remove(id);
        } else System.out.println("Illegal id");

    }

    public void editItem() {
        Map<Integer, Item> itemMap = shop.getItemsMap();
        System.out.println("Введите id:");
        Scanner scId = new Scanner(System.in);
        int id = scId.nextInt();
        if (itemMap.containsKey(id)) {
            itemMap.remove(id);
            Item item = new Item();
            System.out.println("Введите новый id:");
            Scanner scNewId = new Scanner(System.in);
            item.setId(scNewId.nextInt());
            System.out.println("Введите name:");
            Scanner scName = new Scanner(System.in);
            item.setName(scName.nextLine());
            System.out.println("Введите price:");
            Scanner scPrice = new Scanner(System.in);
            item.setPrice(scPrice.nextInt());
            itemMap.putIfAbsent(item.getId(), item);
        } else {
            System.out.println("Illegal id");
        }
    }

    Scanner scanner (Scanner scanner){
        return scanner;
    }
}
