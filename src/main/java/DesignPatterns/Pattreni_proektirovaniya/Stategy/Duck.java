package DesignPatterns.Pattreni_proektirovaniya.Stategy;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.FlyBehavior;
import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.QuackBehavior;

public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;


    public void swim(){
        System.out.println("Swimming");
    }
    public void quack(){
        this.quackBehavior.quack();
    }
    public void fly(){
        this.flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
