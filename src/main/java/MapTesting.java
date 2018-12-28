import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

/*
* При переопределении equals и наследовании hashcode из object происходит следущее:
* У объекта высчитывается hashcode который соответствует ячейке памяти,
* соответственно объекты, которые должны быть равны ,
* распределяются по разным корзинам и никогда не сравниваются по equals.
*
*
* При переопределении только hashcode и наследовании equals из object происходит следущее:
* У объекта вычисляется hashcode и добавляется в соответствующую корзину,
* однако при добавлении элемента который должен быть равен добавленному,
* он добавляется в ту же корзину что и предыдущий, однако при сравнении по equals сравниваются ссылки,
* значит оба одинаковых объекта будут существовать в корзине.
*
*/
public class MapTesting {
    public static void main(String[] args) {
        HashSet<TestClass1> hashTest = new HashSet<>();
        HashSet<TestClass2> equalsTest = new HashSet<>();
        hashTest.add(new TestClass1(1));
        hashTest.add(new TestClass1(1));
        System.out.println(hashTest.size());
        equalsTest.add(new TestClass2(1));
        equalsTest.add(new TestClass2(1));
        System.out.println(equalsTest.size());

        HashSet<NormalClass> normalClasses = new HashSet<>();
        normalClasses.add(new NormalClass(1));
        normalClasses.add(new NormalClass(1));
        normalClasses.add(new NormalClass(2));
        normalClasses.add(new NormalClass(2));
        normalClasses.add(new NormalClass(3));
        System.out.println(normalClasses.size());

        System.out.println();
    }

}

class TestClass1 {
    private int i;

    public TestClass1(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class TestClass2 {
    private Integer j;

    public TestClass2(Integer j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        return this.j.equals(((TestClass2)obj).getJ());
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }
}

class NormalClass {
    Integer j;

    public NormalClass(Integer j) {
        this.j = j;
    }

    @Override
    public int hashCode() {
        return j;
    }

    @Override
    public boolean equals(Object obj) {
        return this.j.equals(((NormalClass)obj).getJ());
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }
}