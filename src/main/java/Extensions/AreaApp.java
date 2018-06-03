package Extensions;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class AreaApp {
    public static void main(String[] args) {
        int width = 5;
        int height = 5;
        Rectangle r = new Rectangle(width,height);
        System.out.println("The rectangle's area is " + Ext.area(r));

    }
}
