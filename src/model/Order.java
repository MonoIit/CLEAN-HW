package model;

import service.CartService;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private long orderId;
    private long userId;
    private boolean status;
    private Map<Good, Integer> cart = new HashMap<>();

    public Order(CartService cart) {
        this.cart = cart.getCart();
    }

    @Override
    public String toString() {
        return "Order number " + orderId + "\n user: " + userId + "\n status: " + ((status) ? "delivered" : "on the way");
    }
}
