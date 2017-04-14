package DesignPatterns.FactoryMethod;

//Теперь мы можешь поменять case 1 на что то другое и во всех местах с передачей 1 в метод будет создан другой объект
public class CarSelector {
    public static Car getCar(CarTypes types){
        Car car = null;
        switch (types){
            case FirstType:
                car = new Car1();
                break;
            case SecondType:
                car = new Car2();
                break;
        }
        return car;
    }

}
