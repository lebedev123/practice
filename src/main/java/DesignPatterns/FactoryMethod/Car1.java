package DesignPatterns.FactoryMethod;

public class Car1 implements Car {
    @Override
    public void drive() {
        System.out.println("Car1 drive");
    }

    @Override
    public void stop() {
        System.out.println("Car1 stop");
    }
}
