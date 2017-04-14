/**
 * Created by dos on 04.12.2016.
 */
public class staticInner {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length;i++){
            d[i] = 100*Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.Pair.minmax(d);
        System.out.println("min= " + p.getFirst());
        System.out.println("min= " + p.getSecond());
    }
}
//Нестатический внутренний класс требует наличие объекта внешнего класса, так как
//он имеет по умолчанию ссылку на объект внешнего класса,статический внутренний
//класс не требует ссылки на объект и может вызываться через OuterClass.InnerClass.method()
//Иначе требуется создавать объект внешнего класса
class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public static Pair minmax(double[] values) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double v : values) {
                if (min > v) min = v;
                if (max < v) max = v;
            }
            return new Pair(min, max);
        }
    }
}

