package Actions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dos on 23.01.2017.
 */
public class RadioButtonFrame extends JFrame{
    private JPanel panel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;
    public RadioButtonFrame(){
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);
        panel = new JPanel();
        group = new ButtonGroup();
        addRadioButton("Small",8);
        addRadioButton("Medium",12);
        addRadioButton("Large",18);
        addRadioButton("Extra large",36);
        add(panel,BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        RadioButtonFrame frame = new RadioButtonFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void addRadioButton(String name,int size){
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name,selected);
        group.add(button);
        panel.add(button);
        ActionListener listener = e -> label.setFont(new Font("Serif",Font.PLAIN,size));
        button.addActionListener(listener);
    }
}
