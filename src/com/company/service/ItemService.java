package com.company.service;

import com.company.Item;
import com.company.Shop;

import java.util.*;
import java.util.function.*;

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
                    for (Item item : listByPrice) {
                        System.out.print("id:" + item.getId() + "; Item: " + item.getName() + "; Price:" + item.getPrice() + "; Date:" + item.getDate() +
                                "; -");
                        item.isExpensive(item.getPrice());
                    }

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
        //Scanner scId = new Scanner(System.in);
        int id = Integer.parseInt(scannerSupplier.get());

        if (itemMap.containsKey(id)) {
            System.out.println("Товар с таким id уже существует");
        } else {
            item.setId(id);
            System.out.println("Введите name:");
            item.setName(scannerSupplier.get());
            System.out.println("Введите price:");
            item.setPrice(Integer.parseInt(scannerSupplier.get()));
            item.setDate();
            itemMap.put(item.getId(), item);
        }
    }

    public void removeItemById() {
        Map<Integer, Item> itemMap = shop.getItemsMap();
        System.out.println("Введите id товара, который нужно удалить");
        //Scanner scannerRemoving = new Scanner(System.in);
        int id = Integer.parseInt(scannerSupplier.get());
        if (itemMap.containsKey(id)) {
            itemMap.remove(id);
        } else System.out.println("Illegal id");

    }

    public void editItem() {
        Map<Integer, Item> itemMap = shop.getItemsMap();
        System.out.println("Введите id:");
        //Scanner scId = new Scanner(System.in);
        int id = Integer.parseInt(scannerSupplier.get());
        if (itemMap.containsKey(id)) {
            itemMap.remove(id);
            Item item = new Item();
            System.out.println("Введите новый id:");
            //Scanner scNewId = new Scanner(System.in);
            item.setId(Integer.parseInt(scannerSupplier.get()));
            System.out.println("Введите name:");
            //Scanner scName = new Scanner(System.in);
            item.setName(scannerSupplier.get());
            System.out.println("Введите price:");
            //Scanner scPrice = new Scanner(System.in);
            item.setPrice(Integer.parseInt(scannerSupplier.get()));
            itemMap.putIfAbsent(item.getId(), item);
        } else {
            System.out.println("Illegal id");
        }
    }

    public int getSumm(){
        int summ = 0;
        BinaryOperator<Integer> addition = (x, y) -> x+y;
        for (Map.Entry<Integer, Item> item : shop.getItemsMap().entrySet()) {
            summ = addition.apply(summ, item.getValue().getPrice());
        }
        return summ;
    }

    public void getTax(){
        double tax;
        UnaryOperator<Double> taxCalc = x -> x*0.2;
        tax = taxCalc.apply((double) getSumm());
        System.out.println("Налог 20% = " + tax);
        Function<Double, String> convert = x -> String.valueOf(x);
        System.out.println(convert.apply(tax));
        Consumer<Double> printer = x -> System.out.println(x);
        printer.accept(tax);
    }

    Supplier<String> scannerSupplier = ()->{
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    };

}
