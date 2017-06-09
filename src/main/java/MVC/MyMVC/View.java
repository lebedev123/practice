package MVC.MyMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements java.util.Observer {
    JButton button1;
    JButton button2;
    Controller controller;
    JTextField textField1;
    JTextField textField2;

    public View(Controller controller) {
        this.controller = controller;
        JFrame frame = new JFrame("Values incrementer");
        frame.add(new Label("Counter"));
        button1 = new JButton("Value1");
        button2 = new JButton("Value2");
        button1.addActionListener(e -> {
            controller.model.incrementValue1();
            //textField1.setText(String.valueOf(controller.getValue1()));
        });
        button2.addActionListener(e -> {
            controller.model.incrementValue2();
            //textField2.setText(String.valueOf(controller.getValue2()));
        });
        textField1 = new JTextField(String.valueOf(controller.getValue1()),3);
        textField2 = new JTextField(String.valueOf(controller.getValue2()),3);
        controller.model.addObserver(this);
        frame.setLayout(new FlowLayout());
        Panel buttonpanel = new Panel();
        buttonpanel.add(button1);
        buttonpanel.add(button2);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(buttonpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        frame.pack();

    }

    @Override
    public void update(Observable o, Object arg) {
        textField1.setText(String.valueOf(controller.getValue1()));
        textField2.setText(String.valueOf(controller.getValue2()));
    }
}
