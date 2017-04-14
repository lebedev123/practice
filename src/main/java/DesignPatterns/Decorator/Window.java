package DesignPatterns.Decorator;

public class Window implements Component{

    @Override
    public void draw() {
        System.out.println("Draw window");
    }
}
