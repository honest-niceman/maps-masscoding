package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Разработайте систему управления заказами в ресторане с использованием Map.
 * Каждый заказ представлен уникальным номером и списком блюд с указанием их количества.
 * Напишите программу, которая добавляет новые заказы, удаляет существующие, выводит
 * общую стоимость заказа по его номеру и выводит список всех блюд в заказе с их количеством.
 */
public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Map<Integer, Map<String, Integer>> orders = new HashMap<>();

        // Добавление новых заказов
        addOrder(orders, 1, "Pizza", 2);
        addOrder(orders, 1, "Pizza", 3);
        addOrder(orders, 2, "Burger", 1);
        addOrder(orders, 3, "Pizza", 1);
        addOrder(orders, 1, "Salad", 1);

        // Вывод списка заказов
        printAllOrders(orders);
    }

    private static void printAllOrders(Map<Integer, Map<String, Integer>> orders) {
        //todo
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
