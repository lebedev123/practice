package DesignPatterns.State;

public class MoveState implements TransformerState {
    @Override
    public void doAction() {
        System.out.println("Moving");
    }
}
