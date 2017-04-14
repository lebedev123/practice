package generics;

public class ext<T> {
    T ob;
    ext(T o){
        ob = o;
    }

    public static void main(String[] args) {
        ext1 ext1= new ext1(new String("LUL"));
    }
}
class ext1<T> extends ext{
    ext1(T ob){
        super(ob);
    }
}
