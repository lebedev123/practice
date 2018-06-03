package DesignPatterns.Pattreni_proektirovaniya.Observer;


/**
 * Паттер Observer позволяет создать класс реализующий Observable и регистрировать у него слушателей
 * При появлении некого события вызывается notify который уведомляет всех слушателей о событии
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Start ");
        DataWeather dataWeather = new DataWeather();
        Observer firstObserver = new ObserverImpl("firstObserver");
        Observer secondObserver = new ObserverImpl("secondObserver" );
        dataWeather.registerObserver(firstObserver);
        dataWeather.registerObserver(secondObserver);
        dataWeather.handleMessage("First notify message");
        dataWeather.removeOnserver(firstObserver);
        dataWeather.handleMessage("Second notify message");
    }
}
