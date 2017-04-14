package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by dos on 18.01.2017.
 */
public class ActionTest extends AbstractAction {

    public ActionTest(String name, Icon icon , Color color) {
        putValue(Action.NAME,name);
        putValue(Action.SMALL_ICON,icon);
        putValue("color",color);
        putValue(Action.SHORT_DESCRIPTION,"Set panel color to" + name.toLowerCase());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color c = (Color) getValue("color");
    }
}
