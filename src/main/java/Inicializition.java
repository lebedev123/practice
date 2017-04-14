/**
 * Created by dos on 13.11.2016.
 */
public class Inicializition {
    int i=0;
    Inicializition increment(){
        i++;
        return this;
    }
    void print(){
        System.out.print("i = " + i);
    }
    public static void main(String[] args){
        Inicializition x = new Inicializition();
        x.increment().increment().increment().print();
    }
}