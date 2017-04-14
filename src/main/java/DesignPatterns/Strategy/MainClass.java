package DesignPatterns.Strategy;

/**
 * Стратегия выбора сортировки
 * Отличие от state то что
 * состояни в state не связаны с собой и управляем состоянием объекта
 * В Strategy все варианты выбора используются
 * для одной цели(сортировки например) и мы управляем поведением объекта
 * В State состояния меняются внутри состояний(прямо в методе смены состояния,если это требуется офк)
 * либо внутри context а в стратегия меняется напрямую main классом либо клиентом
 */
public class MainClass {
    Sorting strategy;
    public void setStrategy(Sorting strategy){
        this.strategy =  strategy;
    }
    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }

    public static void main(String[] args) {
        MainClass main = new MainClass();
        int[] a = {1,2,3};
        main.setStrategy(new SelectionSort());
        main.executeStrategy(a);
    }

}
interface Sorting{
    void sort(int[] arr);
}
class BubbleSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Пузырковая сортировка");
        //сортировка
    }
}
class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка выборкой");
        //сортировка
    }
}