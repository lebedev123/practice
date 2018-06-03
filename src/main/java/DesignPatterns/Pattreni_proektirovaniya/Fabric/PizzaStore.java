package DesignPatterns.Pattreni_proektirovaniya.Fabric;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza(String type);
}
