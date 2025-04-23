import service.CartService;
import service.Catalog;
import service.OrderService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OrderService orderService = new OrderService();
        CartService cartService = new CartService();
        Catalog catalog = new Catalog();

        boolean flag = true;
        int choice;
        while (flag) {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    catalog.showCatalog();
                    catalog.makeChoice(cartService);
                    break;
                }
                case 2: {
                    cartService.showCart();
                    break;
                }
                case 3: {
                    orderService.showOrders();
                    if (!cartService.getCart().isEmpty()) {
                        if (orderService.makeOrder(cartService)) cartService.cleanCart();
                    }
                    break;
                }
                case 0: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
        System.out.println("bye");
    }

    public static void menu() {
        System.out.println("1. Catalog");
        System.out.println("2. Cart");
        System.out.println("3. Order");
        System.out.println("0. Exit");
    }
}