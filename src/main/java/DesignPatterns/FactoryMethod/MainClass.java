package DesignPatterns.FactoryMethod;


/**
 * В классе CarSelector присутствует статический метод
 * getCar который в зависимости от типа переданного в
 * switch(количество типов ограниченно в Enum)
 * возвращает требуемый объект в интерфейс Car
 * Соответственно чтобы изменить объекты которые будут передаваться
 * в интерфейсы, нам не нужно изменять весь код,
 * а требуется только изменить возвращаемый тип в switch
 */
public class MainClass {
    public static void main(String[] args) {
        Car car1 = CarSelector.getCar(CarTypes.FirstType);
        car1.drive();
        car1.stop();
        Car car2 = CarSelector.getCar(CarTypes.SecondType);
        car2.drive();
        car2.stop();

    }
}
