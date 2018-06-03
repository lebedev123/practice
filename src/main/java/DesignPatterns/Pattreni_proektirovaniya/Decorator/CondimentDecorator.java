package DesignPatterns.Pattreni_proektirovaniya.Decorator;

/**
 * Декоратор CondimentDecorator который содержит Beverage к которому будет добавляться конкретная функциональность
 *
 */

public abstract class CondimentDecorator extends  Beverage{
    @Override
    public abstract String getDescription();

}
