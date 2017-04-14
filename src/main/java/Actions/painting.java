package Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dos on 29.09.2016.
 */
public class painting implements ActionListener {
    JFrame frame;
    JButton button;
    public static void main (String[] args){
        painting gui = new painting();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("LUL");
        MyDrawPanel drawPanel = new MyDrawPanel();
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel{
    public  void paintComponent(Graphics g){
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        Color randomColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
}
