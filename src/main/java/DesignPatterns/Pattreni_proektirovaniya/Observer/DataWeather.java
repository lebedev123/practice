package DesignPatterns.Pattreni_proektirovaniya.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс релизующий Observable(Subject в нашем случае)
 * Умеет регитрировать в себе слушателей и при наступлении некого соытия (метод handleMessage)
 * оповещать слушателей
 */

public class DataWeather implements Subject {
    private List<Observer> observers;
    private String notifyString ;

    public DataWeather() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeOnserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(notifyString);
        }
    }

    @Override
    public void handleMessage(String message) {
        this.notifyString = message;
        this.notifyObservers();
    }

}
