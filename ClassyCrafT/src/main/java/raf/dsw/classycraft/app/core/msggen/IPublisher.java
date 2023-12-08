package raf.dsw.classycraft.app.core.msggen;

public interface IPublisher {
    void addSubscriber(ISubscriber subscr);
    void removeSubscriber(ISubscriber subscr);
    void notifySubscribers(Object notification);
}
