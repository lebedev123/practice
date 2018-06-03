package DesignPatterns.Pattreni_proektirovaniya.Observer;

/**
 * Observer который регистрируется у класса DataWeather и при наступлении какого либо события вызывается метод update у всех слушателей
 */

public class ObserverImpl implements Observer{
    private String name;
    private String notifyMessage;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String notify) {
        this.setNotifyMessage(notify);
        this.display();
    }

    @Override
    public void display() {
        System.out.println(this.getName() + ":  I got a message from subject : " + this.getNotifyMessage());
    }

    public String getName() {
        return name;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }
}
