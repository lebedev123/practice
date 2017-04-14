package DesignPatterns.Observer;

import java.util.ArrayList;

public interface PublisherInterface {
    ArrayList<PublisherActionListener> getListeners();
    void addListener(PublisherActionListener listener);
    void removeListener(PublisherActionListener listener);
    void removeAll();
    void notifySubscribers(String msg);

}
