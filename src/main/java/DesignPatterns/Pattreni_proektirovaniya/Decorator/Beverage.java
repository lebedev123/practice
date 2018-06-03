package DesignPatterns.Pattreni_proektirovaniya.Decorator;


/**
 * Корневой класс для декоратора и напитков
 * Unknown beverage - неизвестный напиток
 *
 */

public abstract class Beverage {

    private String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }
    public abstract double getCost();

}
