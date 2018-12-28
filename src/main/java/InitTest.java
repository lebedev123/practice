/**
 * Тест на порядок инициализации блоков
 * 1)Статич блок и статич переменные родителя
 * 2)Статич блок и статич переменные потомка
 * 3)Конструтор родителя
 * 4)Конструтор потомка
 */
public class InitTest {
    public static void main(String[] args) {
        B12 b12 = new B12();
    }

}


class A12{
    public String s1;
    public Integer i1;
    static {
        System.out.println("A12 static");
    }

    public A12(String s1) {
        this.s1 = s1;
    }

    public A12(Integer i1) {
        this.i1 = i1;
    }

    public A12() {
        System.out.println("A12 constructor");
    }
}

class B12 extends A12{
    public String b1;
//    public String s1;

    static {
        System.out.println("B12 static");
    }

    public B12() {
        System.out.println("A12 constructor");
    }
}