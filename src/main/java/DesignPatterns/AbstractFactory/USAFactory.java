package DesignPatterns.AbstractFactory;

public class USAFactory implements TransportFactory{

    @Override
    public Air createAir() {
        return new AeroBus();
    }

    @Override
    public Auto createAuto() {
        return new Ford();
    }
}
