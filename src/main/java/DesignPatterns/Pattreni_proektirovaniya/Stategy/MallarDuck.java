package DesignPatterns.Pattreni_proektirovaniya.Stategy;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.LoudQuack;
import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.RocketFly;

public class MallarDuck extends Duck {
    public MallarDuck() {
        this.flyBehavior = new RocketFly();
        this.quackBehavior = new LoudQuack();
    }

}
