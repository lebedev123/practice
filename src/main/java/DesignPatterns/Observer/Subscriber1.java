package DesignPatterns.Observer;

public class Subscriber1 implements PublisherActionListener {
    @Override
    public void doAction(String msg) {
        System.out.println(msg + " from " + this.getClass().getName());
    }
}
