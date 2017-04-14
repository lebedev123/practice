package SwingTest;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.*;

/**
 * Created by dos on 24.01.2017.
 */
public class SliderFrame extends JFrame {
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        listener = e -> {
            JSlider slider = (JSlider) e.getSource();
            textField.setText("" + slider.getValue());
        };
        //простой ползунок
        JSlider slider = new JSlider();
        addSlider(slider,"Plain");
        //ползунок с основными метками
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Ticks");
        //ползунок с привязываемый к меткам
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Snap to ticks");
        // ползунок без меток
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "No track");
        //обращенный ползунок
        slider = new JSlider();
        slider.setPaintTicks(true);
        ;
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Inverted");
        //ползунок с числовыми обозначениями отметок
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Labels");
        //ползунок с буквенными обозначениями меток
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        java.util.Dictionary<Integer, Component> labelTabel = new Hashtable<>();
        labelTabel.put(0, new JLabel("A"));
        labelTabel.put(20, new JLabel("B"));
        labelTabel.put(40, new JLabel("C"));
        labelTabel.put(60, new JLabel("D"));
        labelTabel.put(80, new JLabel("E"));
        labelTabel.put(100, new JLabel("F"));
        slider.setLabelTable(labelTabel);
        addSlider(slider, "Custom labels");
        //ползунок с пиктограммами
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        labelTabel = new Hashtable<Integer, Component>();
        labelTabel.put(0, new JLabel(new ImageIcon("1.gif")));
        labelTabel.put(60, new JLabel(new ImageIcon("1.gif")));
        labelTabel.put(20, new JLabel(new ImageIcon("2.gif")));
        labelTabel.put(80, new JLabel(new ImageIcon("2.gif")));
        labelTabel.put(40, new JLabel(new ImageIcon("3.gif")));
        labelTabel.put(100, new JLabel(new ImageIcon("3.gif")));
        slider.setLabelTable(labelTabel);
        addSlider(slider, "Icon labels");
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    public void addSlider(JSlider slider, String description) {
        slider.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel, gbc);
    }

    public static void main(String[] args) {
        SliderFrame frame = new SliderFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

