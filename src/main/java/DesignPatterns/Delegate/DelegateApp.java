package DesignPatterns.Delegate;

/**
 * как бы вызвается один метод у Painter но срабатывает метод у класса Square
 */
public class DelegateApp {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.setGraphics(new Square());
        p.draw();
    }
}


interface Graphics {
    void draw();
}

class Triangle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Треугольник");
    }
}

class Square implements Graphics {

    @Override
    public void draw() {
        System.out.println("Квадрат");
    }
}

class Painter {
     Graphics graphics;
    void setGraphics(Graphics g){
        graphics = g;
    }
    void draw(){
        graphics.draw();
    }
}