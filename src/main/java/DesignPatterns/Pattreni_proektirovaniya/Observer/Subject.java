package DesignPatterns.Pattreni_proektirovaniya.Observer;


public interface Subject {
    void registerObserver(Observer observer);
    void removeOnserver(Observer observer);
    void notifyObservers();
    void handleMessage(String message);
}
