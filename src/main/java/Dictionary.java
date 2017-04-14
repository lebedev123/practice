import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Hashtable;

class Dictionary{
    public static void main(String[] args) {

        java.util.Dictionary<Integer, Component> lableTable = new Hashtable<>();
        //lableTable.put(0,new JLabel( new ImageIcon("nine.gif")));
        //lableTable.put(20,new JLabel( new ImageIcon("ten.gif")));
        JSlider slider = new JSlider();
        slider.setLabelTable(lableTable);
        Pair <String>[] n = new Pair[10];
    }
}