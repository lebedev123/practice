import java.util.Random;

/**
 * Created by dos on 07.01.2017.
 */
public class ArrayAlgStaticInner {
    public static void main(String[] args) {
        double[] d = new double[20];
        for(int i =0;i<d.length;i++){
            d[i] = 100 * Math.random();
        }
        ArrayAlg2.Pair p = ArrayAlg2.Pair.minmax(d);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }
}

class ArrayAlg2 {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst()

        {
            return first;
        }

        public double getSecond()

        {
            return second;
        }
        //Нестатический внутренний класс требует наличие объекта внешнего класса, так как
//он имеет по умолчанию ссылку на объект внешнего класса,статический внутренний
//класс не требует ссылки на объект и может вызываться через OuterClass.InnerClass.method()

        public static ArrayAlg2.Pair minmax(double[] values) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double v : values) {
                if (v > max) max = v;
                if (v < min) min = v;
            }
            return new Pair(min, max);
        }
    }

}
