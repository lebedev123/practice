package DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.FlyBehavior;

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cant fly, sorry");
    }
}
