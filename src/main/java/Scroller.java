import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by dos on 05.10.2016.
 */
public class Scroller implements ActionListener{
    JTextArea text;
        public static void main(String [ ] args){
            Scroller field1 = new Scroller();
            field1.go();
        }
        public void go(){
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JButton button= new JButton("Click me");
            button.addActionListener(this);
            text = new JTextArea(10,20);//constructor (10 strok, 20 stolbcov)
            JScrollPane scrollPane = new JScrollPane(text);//scroll
            text.setLineWrap(true);//perenos texta
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//vertical prokrytka vsegda
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//horizaotal never
            panel.add(scrollPane);
            frame.getContentPane().add(BorderLayout.CENTER,panel);
            frame.getContentPane().add(BorderLayout.SOUTH,button);
            frame.setSize(350,300);
            frame.setVisible(true);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        text.append("Button clicked \n");// \n perevodit na next stroky
    }
}
