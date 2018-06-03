package DesignPatterns.Pattreni_proektirovaniya.Fabric;

/**
 *
 * Фабрика определяет интерфейс создания объекта(PizzaStore) но позволяет субьектам
 * выбрать класс создаваемого экземпляра.
 * Фабричный метод делегирует операцию создания экземпляра субклассам
 *
 * PizzaStore(определяет все методы для работы с объектами кроме фабричного метода)
 * NYFactory/ChicagoFactory (наследуют PizzaStore и реализуют фабрич методы)
 * Pizza (определяет интерфейс для всех объектов)
 * ChicagoWithCheese/NYStandard(реализует интерфейс объектов)
 *
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore storeInNY = new NYFactory();
        PizzaStore storeInChicago = new ChicagoFactory();
        Pizza one = storeInNY.orderPizza("cheese");
        System.out.println("Ordered " + one.getName());
        Pizza two = storeInChicago.orderPizza("standard");
        System.out.println("Ordered " + two.getName());
    }
}
