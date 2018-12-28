package DesignPatterns.Pattreni_proektirovaniya.Stategy;


import DesignPatterns.Pattreni_proektirovaniya.Stategy.Behaviors.NoFly;

/**
 * Паттерн стратегия - поведение инкапсулируется в отдельном наборе классов
 * Если поведение классов постоянно меняется то лучше не переписывать класс каждый раз,
 * а вынести все изменения в отдельную иерархию и классы.
 * Таким образом путем композиции мы добиваемся гибкости приложения
 *
 * По факту мы все равно должны впилить нужные реализации поведения во ВСЕ конструкторы "уток", чтобы потом перепиливать лишь классы поведения
 */
public class Main {

    public static void main(String[] args) {
        Duck mallarDuck = new MallarDuck();
        mallarDuck.swim();
        mallarDuck.fly();
        mallarDuck.quack();
        mallarDuck.setFlyBehavior(new NoFly());
        mallarDuck.fly();
    }
}
