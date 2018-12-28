package DesignPatterns.Pattreni_proektirovaniya.Adapter;

public class WildTurkey implements Turkey {

    public void fly() {
        System.out.println("Im flying a short distance");
    }

    public void gobble() {
        System.out.println("Gobble gobble");
    }
}
