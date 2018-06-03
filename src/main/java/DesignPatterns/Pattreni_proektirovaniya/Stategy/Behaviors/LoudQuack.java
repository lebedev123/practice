package DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors;

public class LoudQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("LoudQuack");
    }
}
