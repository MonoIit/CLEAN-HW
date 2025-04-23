package service;

import model.Apples;
import model.Bread;
import model.Good;
import model.Milk;

import java.util.List;
import java.util.Scanner;

public class Catalog {
    private final List<Good> goods = List.of(
            new Apples(500),
            new Milk(1000),
            new Bread(700)
    );
    private final int NUMBER_GOODS = goods.size();

    Scanner sc = new Scanner(System.in);

    public void showCatalog() {
        for (int i = 0; i < NUMBER_GOODS; ++i) {
            System.out.println(i+1 + ". " + goods.get(i));
        }
        System.out.println("0. return back");
    }

    public void makeChoice(CartService cart) {
        int choiceProduct;
        int choiceOption;

        choiceProduct = sc.nextInt();
        if (choiceProduct == 0) {
            return;
        }
        choiceProduct--;

        goods.get(choiceProduct).showOptions();
        choiceOption = sc.nextInt();
        if (choiceOption == 1) {
            System.out.println("Enter number of " + goods.get(choiceProduct).getName() + " you want");
            int choiceNumber = sc.nextInt();
            cart.addProduct(goods.get(choiceProduct), choiceNumber);
            System.out.println(goods.get(choiceProduct).getName() + " added");
        }
        else if (choiceOption == 2) {
            int rate;
            System.out.println("Enter rate from 1 to 5");
            rate = sc.nextInt();
            if (rate <= 0 || rate > 5) {
                System.out.println("Invalid rate");
                return;
            }
            goods.get(choiceProduct).rate(rate);
        }

    }
}
