package DesignPatterns.Pattreni_proektirovaniya.Decorator.Condiments;

import DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverage;
import DesignPatterns.Pattreni_proektirovaniya.Decorator.CondimentDecorator;


/**
 * Кдасс дополнения(шоколад) к напитку который инкапсулирует в себе напиток и
 * расширияет его функциональность тем самым добавляя стоимость кофе к стоимости молока.
 * Это позволяет создать различные комбинации напитком и дополнений.
 */

public class Chocolate extends CondimentDecorator {
    private Beverage beverage;
    private String description = "Chocolate";
    private double cost = 0.3;

    public Chocolate(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " +  this.description;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + this.cost;
    }
}
