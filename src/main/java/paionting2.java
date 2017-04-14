import javax.swing.*;
import java.awt.*;

/**
 * Created by dos on 02.10.2016.
 */
public class paionting2 {
    JFrame frame;
    int x =70;
    int y =70;
    public static void main(String[] args){
        paionting2 paint = new paionting2();
        paint.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel1 panel1 = new MyDrawPanel1();

        frame.getContentPane().add(panel1);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i=0;i<130;i++){
            x++;
            y++;
            panel1.repaint();
            try{
                Thread.sleep(50);
            }catch (Exception ex){}
    }}
class MyDrawPanel1 extends JPanel{
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.black);
        g.fillOval(x,y,100,100);
    }
}}
