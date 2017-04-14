package Actions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by dos on 23.01.2017.
 */
public class Borders extends JFrame{
    private JPanel demopanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public static void main(String[] args) {
        Borders borders = new Borders();
        borders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borders.setVisible(true);
    }
    public Borders(){
        demopanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        addRadioButton("Lowered level",BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised level",BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched",BorderFactory.createEtchedBorder());
        addRadioButton("Line",BorderFactory.createLineBorder(Color.blue));
        addRadioButton("Matte",BorderFactory.createMatteBorder(10,10,10,10,Color.BLUE));
        addRadioButton("Empty",BorderFactory.createEmptyBorder());
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched,"Border Types");
        buttonPanel.setBorder(titled);
        buttonPanel.setSize(100,100);
        setLayout(new BorderLayout());
        add(buttonPanel,BorderLayout.NORTH);
        add(demopanel,BorderLayout.CENTER);
        pack();
    }
    public void addRadioButton(String name, Border border){
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(event->demopanel.setBorder(border));
        group.add(button);
        buttonPanel.add(button);
    }
}
