package MVC.Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class CelsiusGUI extends TemperatureGUI {
    public CelsiusGUI(TemperatureModel model, int h, int v) {
        super("CelsuisModel", model, h, v);
        setDisplay(String.valueOf(model.getC()));
        addDisplayListener(new DisplayListener());
        addUpListener(new UpButtonListener());
        addDownListener(new DownButtonListener());
    }

    @Override
    public void update(Observable o, Object arg) {
        setDisplay(String.valueOf(model().getC()));
    }


    class DisplayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double value = getDisplay();
            model().setC(value);
        }
    }

    class UpButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model().setC(model().getC() + 1);
        }
    }
    class DownButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model().setC(model().getC()-1);
        }
    }
}
