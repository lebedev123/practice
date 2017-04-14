package DesignPatterns.Observer;

import java.util.ArrayList;

public class Publisher implements PublisherInterface {
    private ArrayList<PublisherActionListener> listeners = new ArrayList<>();

    @Override
    public ArrayList<PublisherActionListener> getListeners() {
        return  listeners;
    }

    @Override
    public void addListener(PublisherActionListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(PublisherActionListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeAll() {
        listeners.clear();
    }

    @Override
    public void notifySubscribers(String msg) {
        for(PublisherActionListener listener : listeners){
            listener.doAction(msg);
        }
    }
    void createMessage(String msg){
        System.out.println("Publisher printed message " + msg);
        notifySubscribers(msg);
    }
}
