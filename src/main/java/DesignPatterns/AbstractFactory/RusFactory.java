package DesignPatterns.AbstractFactory;

public class RusFactory implements TransportFactory {
    @Override
    public Air createAir() {
        return new TU();
    }

    @Override
    public Auto createAuto() {
        return new Shaxa();
    }
}
