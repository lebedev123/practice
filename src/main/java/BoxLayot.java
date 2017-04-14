import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 05.10.2016.
 */
public class BoxLayot {
    public static void main(String[] args){
        BoxLayot gui = new BoxLayot();
        gui.go();
    }
    public void go(){
        JPanel panel = new JPanel();
        JFrame frame  = new JFrame();
        JButton button = new JButton("LOL");
        JButton button2 = new JButton("LOL");
        panel.add(button);
        panel.add(button2);
        panel.setBackground(Color.green);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}
