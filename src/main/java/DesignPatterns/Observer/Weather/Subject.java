package DesignPatterns.Observer.Weather;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);


    void notifyObservers();
}

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    void display();
}
