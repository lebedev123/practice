package generics;

public class Stats <T extends Number> {
    T[] nums;
    Stats(T[] o){
        nums = o;
    }
    double average(){
        double summ = 0.0;
        for(int i=0;i< nums.length;i++){
            summ += nums[i].doubleValue();
        }
        return summ;
    }
    boolean sameAvg(Stats<?> ob){ // вмсето T, для этого типы должны совпадать
        if(average() == ob.average()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Stats<Integer> integer = new Stats<>(new Integer[]{10,13,0,14});
        Stats<Double> doubleStats = new Stats<>(new Double[]{10.0,13.0,14.0});
        integer.sameAvg(doubleStats);
    }
}
