package DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverages;


import DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverage;

/**
 * Конкретный напиток - DarkRoast - объкт к которому декоратор будет добавлять функциональность
 */

public class DarkRoast extends Beverage {

    private String description = "Dark Roast Beverage";
    private double cost = 1.99;


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
