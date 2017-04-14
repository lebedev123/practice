package DesignPatterns.Decorator;

/**
 * В класс Decorator(Обертка) передается объект типа Component и
 * переопределяется draw так что к нему добавляется
 * нужный нам функционал.В добавленном функционале переопределяется
 * метод afterDraw который выполняется после основного функционала.
 * В итоге функционал Window и TextView не изменяется, объекты этих типов
 * просто оборачиваются
 */
public class MainClass {
    public static void main(String[] args) {

        Component windowWithDecorator = new BorderDecorator(new Window());
        windowWithDecorator.draw();
        Component textView = new ColorDecorator(new TextView());
        textView.draw();
    }
}
