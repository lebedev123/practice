package collections.Lesson;

import java.util.ArrayList;
import java.util.List;

public class Product {
    String name;
    int price;

    static <T extends Product> boolean find(List<T> all, Product p) {
        for (T sp: all) {
            if (sp.name == p.name) {
                return true;
            }
        }
        return false;
    }
    static boolean findWithWildCard(List<? extends Product> all, Product p) {
        for (Product sp : all) {
            if (sp.name == p.name) {
                return true;
            }
        }
        return false;
    }
    static  void copy(List<?extends Product> src,List<? super Product> dest){
        for(Product p : src){
            dest.add(p);
        }
    }


    public static void main(String[] args) {
        Container<Product> c1;
        Container<Camera> c2;
        Container<Phone> c3;
        //WildCards
        List<Camera> cameras = new ArrayList<>();
        find(cameras,new Camera());
        List<Product> products = new ArrayList<>();
        find(products,new Camera());
        /* Ошибка так как List<Cameras> не наследуется
        от List<Product>
                   Collection<Camera>
                          |
                    List<Camera>
        наследование происходит не по типу а по коллекции иначе
        можно было бы написать
        List<String> a = new Arralist<>();
        List<Object> a1 = a;
        a1.add(new Object);
        String s = a.get(0); Object нельзя привести к String
        Для решения этого используются WildCards
        */
        findWithWildCard(cameras,new Camera());
    }
}

class Camera extends Product {
    int pixel;
}

class Phone extends Product {
    String model;
}

class Container<T extends Product> {
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
