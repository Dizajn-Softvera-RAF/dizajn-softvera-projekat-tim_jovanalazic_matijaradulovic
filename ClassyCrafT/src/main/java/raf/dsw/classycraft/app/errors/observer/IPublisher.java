package raf.dsw.classycraft.app.errors.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber subscr);
    void removeSubscriber(ISubscriber subscr);
    void notifySubscribers(Object notification);
}
