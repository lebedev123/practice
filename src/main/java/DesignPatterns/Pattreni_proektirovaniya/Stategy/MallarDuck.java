package DesignPatterns.Pattreni_proektirovaniya.Stategy;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.LoudQuack;
import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.RocketFly;

/**
 * Утка которая летает со скоростью ракеты и громко орет
 */
public class MallarDuck extends Duck {
    public MallarDuck() {
        this.flyBehavior = new RocketFly();
        this.quackBehavior = new LoudQuack();
    }

}
