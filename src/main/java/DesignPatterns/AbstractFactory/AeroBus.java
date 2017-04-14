package DesignPatterns.AbstractFactory;

public class AeroBus implements Air {
    public AeroBus() {

    }

    @Override
    public void flight() {
        System.out.println("9/11");
    }
}
