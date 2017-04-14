package DesignPatterns.FactoryMethod;

public class Car2 implements Car {
    @Override
    public void drive() {
        System.out.println("Car2 drive");
    }

    @Override
    public void stop() {
        System.out.println("Car2 stop");
    }
}
