package MVC.MyMVC;

public class Model extends java.util.Observable {
    int value1;
    int value2;

    public Model() {
        value1 = 0;
        value2 = 0;
    }

    public void incrementValue1() {
        value1++;
        System.out.println("Value1 incremented. Value1 = " + value1);
        setChanged();
        notifyObservers(value1);
    }

    public void incrementValue2() {
        value2++;
        System.out.println("Value2 incremented. Value2 = " + value2);
        setChanged();
        notifyObservers(value2);
    }

}
