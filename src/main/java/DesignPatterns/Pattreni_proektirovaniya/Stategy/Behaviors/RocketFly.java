package DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.FlyBehavior;

public class RocketFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Fly on rocket");
    }
}
