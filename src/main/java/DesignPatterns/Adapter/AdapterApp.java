package DesignPatterns.Adapter;

/**
 * Есть класс RasterGraphics но клиент умеет
 * работать только c VectorGrapghicsInterface
 * поэтому нужен адаптер
 *
 */
public class AdapterApp {
    public static void main(String[] args) {

    }
}
interface VectorGrapghicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{//растровая графика
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGrapghicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
