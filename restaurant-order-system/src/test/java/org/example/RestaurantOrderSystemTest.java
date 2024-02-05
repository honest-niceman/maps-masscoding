package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantOrderSystemTest {
    @Test
    void addOrder_shouldAddNewOrder() {
        Map<Integer, Map<String, Integer>> orders = new HashMap<>();

        RestaurantOrderSystem.addOrder(orders, 1, "Pizza", 2);

        assertTrue(orders.containsKey(1));
        assertEquals(2, orders.get(1).get("Pizza"));
    }

    @Test
    void addOrder_shouldAddDishToExistingOrder() {
        Map<Integer, Map<String, Integer>> orders = new HashMap<>();
        RestaurantOrderSystem.addOrder(orders, 1, "Pizza", 2);
        RestaurantOrderSystem.addOrder(orders, 1, "Salad", 1);

        assertTrue(orders.containsKey(1));
        assertEquals(2, orders.get(1).get("Pizza"));
        assertEquals(1, orders.get(1).get("Salad"));
    }

    @Test
    void calculateTotalCost_shouldReturnCorrectTotalCost() {
        Map<Integer, Map<String, Integer>> orders = new HashMap<>();
        RestaurantOrderSystem.addOrder(orders, 1, "Pizza", 2);
        RestaurantOrderSystem.addOrder(orders, 2, "Burger", 1);
        RestaurantOrderSystem.addOrder(orders, 3, "Salad", 3);

        double totalCost = RestaurantOrderSystem.calculateTotalCost(orders.get(3));
        assertEquals(5.99 * 3, totalCost);
    }

    @Test
    void createMenu_shouldReturnValidMenu() {
        Map<String, Double> menu = RestaurantOrderSystem.createMenu();

        assertEquals(12.99, menu.get("Pizza"));
        assertEquals(8.99, menu.get("Burger"));
        assertEquals(5.99, menu.get("Salad"));
    }
}