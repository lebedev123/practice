

/**
 * Created by dos on 09.11.2016.
 */
public class ForEach {
    public  static void main(String[] args){
        for(char c: "Forsen is swedish roleplayer".toCharArray()){
            System.out.print(c+" ");
        }
    }
}
class Range < T extends Comparable<T>>{
    private  T min;
    private  T max;
    public Range(T min, T max){
        this.min = min;
        this.max = max;
    }
    public boolean within (T value){
        System.out.println(min.compareTo(value) + " " +   max.compareTo(value) + " ");
        return  min.compareTo(value)<= 0 && max.compareTo(value)>=0;
    }
    public static void main(String[] args){
        Range range = new Range(34,45);
        range.within(34);
    }
}
class ForEachInt {

}
