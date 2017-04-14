package DesignPatterns.FactoryMethod.Pizza;

public class ChicagoFactory extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new ChicagoWithCheese();
        else if (type.equals("standard")) {
            return new ChicagoStandard();
        } else return null;
    }
}

class NYFactory extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new NYWithCheese();
        else if (type.equals("standard")) {
            return new NYStandard();
        } else return null;
    }
}