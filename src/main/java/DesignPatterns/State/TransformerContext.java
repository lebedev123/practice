package DesignPatterns.State;

public class TransformerContext implements TransformerState{
    private TransformerState state;

    public TransformerState getState() {
        return state;
    }

    public void setState(TransformerState state) {
        this.state = state;
    }

    @Override

    public void doAction() {
        this.state.doAction();
    }
}
