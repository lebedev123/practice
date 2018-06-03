package DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverages;


import DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverage;

/**
 * Конкретный напиток - Espresso - объкт к которому декоратор будет добавлять функциональность
 */

public class Espresso extends Beverage {

    private String description = "Espresso";
    private double cost = 1.59;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
