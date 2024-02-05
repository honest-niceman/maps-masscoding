package org.example;

import java.util.HashMap;
import java.util.Map;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Map<Integer, Map<String, Integer>> orders = new HashMap<>();

        // Добавление новых заказов
        addOrder(orders, 1, "Pizza", 2);
        addOrder(orders, 1, "Pizza", 3);
        addOrder(orders, 2, "Burger", 1);
        addOrder(orders, 3, "Pizza", 1);
        addOrder(orders, 1, "Salad", 1); // Добавление блюда к существующему заказу

        // Вывод списка заказов
        System.out.println("Orders:");
        orders.forEach((orderNumber, order) -> {
            System.out.println("Order #" + orderNumber);
            order.forEach((dish, quantity) -> System.out.println("  " + dish + ": " + quantity));
            System.out.println("Total Cost: $" + calculateTotalCost(order));
            System.out.println();
        });
    }

    public static void addOrder(Map<Integer, Map<String, Integer>> orders, int orderNumber, String dish, int quantity) {
        //todo
    }

    public static double calculateTotalCost(Map<String, Integer> order) {
        //todo
    }

    public static Map<String, Double> createMenu() {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Pizza", 12.99);
        menu.put("Burger", 8.99);
        menu.put("Salad", 5.99);
        return menu;
    }
}
