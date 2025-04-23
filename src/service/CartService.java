package service;

import model.Good;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private long totalPrice = 0;
    private Map<Good, Integer> cart = new HashMap();

    public void addProduct(Good product, int number) {
        cart.put(product, cart.getOrDefault(product, 0) + number);
        totalPrice += (long) product.getPrice();
    }

    public void cleanCart() {
        totalPrice = 0;
        cart.clear();
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        System.out.println("Your cart:");
        for (Good good : cart.keySet()) {
            System.out.println(good.getName() + " - " + cart.get(good));
        }
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public Map<Good, Integer> getCart() {
        return cart;
    }
}
