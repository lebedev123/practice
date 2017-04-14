package collections.Lesson.Set;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by dos on 15.12.2016.
 */
public class TestEnumSet {
    public enum Color {
        RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
        private int r;
        private int g;
        private int b;

        private Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }
    }

    public static void main(String args[]) {
        EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
        drawLine(yellow);
        EnumSet<Color> white = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
        drawLine(white);
        EnumSet<Color> pink = EnumSet.of(Color.RED, Color.BLUE);
        drawLine(pink);
    }

    public static void drawLine(Set<Color> colors) {
        System.out.println("Requested Colors to draw lines : " + colors);
        for (Color c : colors) {
            System.out.println("drawing line in color : " + c);
        }
    }
}


