package MVC.Temperature;

public class MVCTemp {
    public static void main(String args[]) {
        TemperatureModel temperature = new TemperatureModel();
        new FarenheitGUI(temperature, 100, 100);
        new CelsiusGUI(temperature,100, 250);
        new SliderGUI(temperature,200,300);
        new GraphGUI(temperature,300,300);
    }
}

