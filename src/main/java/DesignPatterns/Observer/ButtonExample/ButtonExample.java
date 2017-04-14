package DesignPatterns.Observer.ButtonExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample {
    JFrame frame;
    void go(){
        frame = new JFrame();
        JButton button = new JButton("Should i do this?");
        button.addActionListener(e -> {
            int m = (int) (Math.random()*10);
            if(m>5) System.out.println("Fuck it");
            else System.out.println("JUST DO IT");
        });
        frame.setSize(300,300);
        frame.getContentPane().add(BorderLayout.CENTER,button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonExample().go();
    }
}
