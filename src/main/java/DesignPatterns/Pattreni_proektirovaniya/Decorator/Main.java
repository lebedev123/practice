package DesignPatterns.Pattreni_proektirovaniya.Decorator;

import DesignPatterns.Pattreni_proektirovaniya.Decorator.Beverages.Espresso;
import DesignPatterns.Pattreni_proektirovaniya.Decorator.Condiments.Milk;

/**
 * Декоратор позволяет добавлять новую функциональность с объекту.
 * Объект декоратор должен реализовать тот же суперкласс/интерфейс что и декорируемый объект и инкапсулирует в себе декорируемый объект.
 * Иерархия такова
 *               Beverage
 *              /        \
 *            /           \
 *       Espresso         Decorator
 *                          /      \
 *                        Milk      Chocolate
 *
 *
 */

public class Main {

    public static void main(String[] args) {
        Milk milkWithEspresso = new Milk(new Espresso());
        System.out.println(milkWithEspresso.getDescription() + " cost :" + milkWithEspresso.getCost());

    }
}
