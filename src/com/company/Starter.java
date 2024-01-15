package com.company;

import com.company.service.ItemService;

import java.util.Scanner;

public class Starter {
    Starter (){}

    void start (){

        ItemService itemService = new ItemService();
        int ch;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("выберите действие");
            System.out.println("1. Вывод товара; 2. Добавление товара; 3. Удаление товара по id; 4. Редактировние товара.");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    itemService.sortingMap();
                    break;

                case 2:
                    itemService.addItem();
                    break;

                case 3:
                    itemService.removeItemById();
                    break;
                case 4:
                    itemService.editItem();
                    break;
                case 5:

            }

        } while (ch != 0);

    }
}
