package DesignPatterns.Decorator;

public class TextView implements Component {
    @Override
    public void draw() {
        System.out.println("Draw text view");
    }
}
