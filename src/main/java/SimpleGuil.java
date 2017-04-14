import javax.swing.*;

/**
 * Created by dos on 28.09.2016.
 */
public class SimpleGuil {
    public void changeIt(){

    }
    public static void main (String[] args){
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
