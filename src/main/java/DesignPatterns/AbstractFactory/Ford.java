package DesignPatterns.AbstractFactory;

public class Ford implements Auto {
    public Ford() {
    }

    @Override
    public void drive() {
        System.out.println("just drive");
    }
}
