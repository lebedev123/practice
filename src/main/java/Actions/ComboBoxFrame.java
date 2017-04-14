package Actions;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 24.01.2017.
 */
public class ComboBoxFrame extends JFrame{
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;
    public ComboBoxFrame(){
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");
        faceCombo.addActionListener(e -> label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEFAULT_SIZE)));
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel,BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        ComboBoxFrame frame= new ComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
