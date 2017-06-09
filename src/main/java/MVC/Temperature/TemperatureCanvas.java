package MVC.Temperature;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

class TemperatureCanvas extends Canvas {
    public TemperatureCanvas(TemperatureGauge farenheit) {
        _farenheit = farenheit;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(left, top, width, height);
        g.setColor(Color.red);
        g.fillOval(left - width / 2, top + height - width / 3, width * 2, width * 2);
        g.setColor(Color.black);
        g.drawOval(left - width / 2, top + height - width / 3, width * 2, width * 2);
        g.setColor(Color.white);
        g.fillRect(left + 1, top + 1, width - 1, height - 1);
        g.setColor(Color.red);
        long redtop = height * (_farenheit.get() - _farenheit.getMax()) / (_farenheit.getMin() - _farenheit.getMax());
        g.fillRect(left + 1, top + (int) redtop, width - 1, height - (int) redtop);
    }

    private TemperatureGauge _farenheit;
    private static final int width = 20;
    private static final int top = 20;
    private static final int left = 100;
    private static final int right = 250;
    private static final int height = 200;
}

class TemperatureGauge {
    public TemperatureGauge(int min, int max) {
        Min = min;
        Max = max;
    }

    public void set(int level) {
        current = level;
    }

    public int get() {
        return current;
    }

    public int getMax() {
        return Max;
    }

    public int getMin() {
        return Min;
    }

    private int Max, Min, current;
}

class GraphGUI extends Frame implements Observer {
    public GraphGUI(TemperatureModel model, int h, int v) {
        super("Temperature Gauge");
        this.model = model;
        _farenheit = new TemperatureGauge(-200, 300);
        Panel Top = new Panel();
        add("North", Top);
        gauges = new TemperatureCanvas(_farenheit);
        gauges.setSize(500, 280);
        add("Center", gauges);
        setSize(230, 400);
        setLocation(h, v);
        setVisible(true);
        model.addObserver(this); // Connect to the model
    }

    public void update(Observable obs, Object o) // Respond to changes
    {
        repaint();
    }

    public void paint(Graphics g) {
        int farenheit = (int) model.getF(); // Use the current data to paint
        _farenheit.set(farenheit);
        gauges.repaint();
        super.paint(g);
    }

    private TemperatureModel model;
    private Canvas gauges;
    private TemperatureGauge _farenheit;
}
