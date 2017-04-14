package DesignPatterns.State;

public class FireState implements TransformerState {
    @Override
    public void doAction() {
        System.out.println("Fire the plebs");
    }
}
