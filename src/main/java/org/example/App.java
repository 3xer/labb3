package org.example;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.*;
import service.Wearehouse;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello There!");
        int id = 0;
        String name  = "Monster";
        Category category = Category.Big;
        int rating = 7;
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = currentTime.format(timeFormat);
        System.out.println(time);
        Product product = new Product(id, name, category, rating, currentTime);
        Product product2 = new Product(1, "mango loco", Category.Medium, 6, currentTime);

        Wearehouse wearehouse = new Wearehouse();
        wearehouse.addProduct(product);
        wearehouse.addProduct(product2);
        System.out.println(wearehouse.getProduct(0));
        System.out.println(wearehouse.getProduct(1));
        System.out.println();



    }

}
