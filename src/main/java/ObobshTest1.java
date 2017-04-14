/**
 * Created by dos on 06.12.2016.
 */
public class ObobshTest1 {
    public static void main(String [] args){
        String[] word = {"Mary","Andrew","lamb","smth else"};
        Pair<String> mm = ArrayAlg1.minmax(word);
        System.out.print(mm.getFirst() + " " + mm.getSecond());
    }

}
class ArrayAlg1{
    public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0) return null;
        String min  = a[0];
        String max = a[0];
        for(int i =0;i<a.length;i++){
            if(min.compareTo(a[i] )>0) min = a[i];
            if(max.compareTo(a[i])<0) max = a[i];
        }
        return new Pair<>(min,max);
    }
}
class Pair<T>{
    private T first;
    private T second;
    public Pair(){
        first = null;
        second = null;
    }
    public Pair(T first,T second){
        this.second = second;
        this.first = first;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return  second;
    }
    public void setFirst(T newValue){
        this.first = newValue;
    }
    public void setSecond(T newValue){
        this.second = newValue;
    }
    public void Hello(T newvalue){
        System.out.println("Hello, Im new value from Pair" + newvalue.toString());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
