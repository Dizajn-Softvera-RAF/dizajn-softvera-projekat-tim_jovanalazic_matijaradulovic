package raf.dsw.classycraft.app.errors.observer;

import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements IPublisher{
    List<ISubscriber> subscribers;

    public MessageGenerator() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(ISubscriber subscr) {
        subscribers.add(subscr);
    }
    @Override
    public void removeSubscriber(ISubscriber subscr) {
        subscribers.remove(subscr);
    }
    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub:subscribers) {
            sub.react(notification);
        }
    }
}
