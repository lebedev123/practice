package DesignPatterns.Pattreni_proektirovaniya.Decorator.Condiments;

import DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverage;
import DesignPatterns.Pattreni_proektirovaniya.Decorator.CondimentDecorator;

/**
 * Класс дополнения(молоко) к напитку который инкапсулирует в себе напиток и
 * расширияет его функциональность тем самым добавляя стоимость кофе к стоимости молока.
 * Это позволяет создать различные комбинации напитком и дополнений.
 */

public class Milk extends CondimentDecorator {
    private Beverage beverage;
    private String description = "Milk";
    private double cost = 0.2;

    public Milk(Beverage beverage) {
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
