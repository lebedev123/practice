package DesignPatterns.AbstractFactory;

public class Shaxa implements Auto {
    public Shaxa() {
        String jopa = "Vam jopa";
    }

    @Override
    public void drive() {
        System.out.println("Вам выпал объект Shaxa.Вы намотались на столб");
    }
}
