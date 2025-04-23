package service;

import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private Scanner sc = new Scanner(System.in);
    private List<Order> orders = new ArrayList<>();

    public boolean makeOrder(CartService cart) {

        System.out.println("Make an order?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = sc.nextInt();
        if (choice == 1) {
            orders.add(new Order(cart));
            return true;
        }
        return false;
    }

    public void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("You have no orders");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
