package raf.dsw.classycraft.app.core.msggen.generator;

public interface IPublisher {
    void addSubscriber(ISubscriber subscr);
    void removeSubscriber(ISubscriber subscr);
    void notifySubscribers(Object notification);
}
