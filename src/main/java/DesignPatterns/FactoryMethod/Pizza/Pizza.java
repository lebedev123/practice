package DesignPatterns.FactoryMethod.Pizza;

import java.util.ArrayList;

public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare() {
        System.out.println("Preparing pizza " + name);
        System.out.println("Tossing dough " + dough);
        System.out.println("Adding sauce " + sauce);
        System.out.println("Adding toppings ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.print(toppings.get(i) + " ");
        }
    }

    void bake() {
        System.out.println("Bake for 25 min");
    }
    void box(){
        System.out.println("Place pizza in box");
    }
    String getName(){
        return name;
    }

}


