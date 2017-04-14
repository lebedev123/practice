package DesignPatterns.AbstractFactory;

import java.util.Scanner;

/**
 * В зависимости от сообщения введенного в консоль,
 * создается нужная фабрика и с помощью ее впоследствии
 * создаются объекты.
 * В отличии от Factory Method создается целый стек объектов с помощью фабрики
 */
public class MainClass {
    public static void main(String[] args) {
        String msg;
        TransportFactory factory;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите rus или usa");
        msg = scanner.nextLine();
        if (msg.equals("rus")) {
            factory = new RusFactory();
            System.out.println("Вы создали rus factory");
        } else {
            factory = new USAFactory();
            System.out.println("Вы создали usa factory");
        }
        Auto auto = factory.createAuto();
        Air air = factory.createAir();
        auto.drive();
        air.flight();

    }
}
