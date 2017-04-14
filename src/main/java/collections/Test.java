package collections;

import java.util.List;

/**
 * Если мы используем T в аргументе метода сравнения и создаем объект doubleNumericFns<Double>
 * то и в методе сравнения будет автоматически подставлен Double,
 * чтобы использовать метод для разных чисел мы меняем T на ?
 */
public class Test {
    public static void main(String[] args) {
        NumericFns<Double> doubleNumericFns = new NumericFns<>(34.5);
        NumericFns<Float> floatNumericFns = new NumericFns<Float>((float) -1.25);

    }

}
class NumericFns<T extends Number>{
    T num;
    public NumericFns(T num) {
    this.num = num;
    }
    boolean absEquals(NumericFns<?super Number> a){
        if(Math.abs(num.doubleValue()) == Math.abs(a.num.doubleValue()) ) return true;
        else return false;
    }
    //<E super Number>void  abs(List<E> a) нельзя использовать generics и super, Только ?


}